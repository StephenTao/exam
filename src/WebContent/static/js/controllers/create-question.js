define(['modules/controller', 'jQuery', 'angular', 'lib/tool', 'services/question', 'services/dashboard', 'jqueryi18n'],
    function(controller, $, angular, tool) {
        controller.controller('createQuestionCtrl', ['$scope', '$http', 'questionService', 'dashboardService', '$timeout',
            function($scope, $http, questionService, dashboardService, $timeout) {
            $scope.staticUrl = STATIC_URL;
            $scope.max = STATIC_URL + 'static/images/max.png';
            $scope.audio = STATIC_URL + 'static/images/8ICN_Voice_10x15.png';
            $scope.image = STATIC_URL + 'static/images/12ICN_AddPicture_10x15.png';
            $scope.video = STATIC_URL + 'static/images/10ICN_AddVideo_15x10.png';
            $scope.showMax = STATIC_URL + 'static/images/show_max.png';
            $scope.question = {
                edit : STATIC_URL + 'static/html/question/choice.html',
                refView : STATIC_URL + 'static/html/question/show-choice.html',
                minDel : STATIC_URL + 'static/images/mindelete.png',
                deleteImg : STATIC_URL + 'static/images/delete.png',
                closeBtn : STATIC_URL + 'static/images/29BTN_Delete_CreateQ_15x15.png',
                uploadUrl : STATIC_URL + 'static/html/upload/upload.html',
                isHasBorder : 'no-border',
                searchTagList : [],
                ulVisible : false,
                formData : {
                    tagValue : '',
                    tagId : 0,
                    tags : [{
                        id : 0,
                        name : '',
                        visible : false
                    }],
                    title : '',
                    answer : '',
                    questionTypeId : 2,
                    options : [{
                        correct : 0,
                        title : '',
                        id : 0,
                        character : 'A',
                        visible : false,
                        background : 'image-unchecked',
                    }]
                }
            };
            $scope.validator = {
                tag : false,
                option : false,
                answer : false,
                title : false
            };

            $scope.upload = function(file, errFiles) {
                $scope.errFile = errFiles && errFiles[0];
                if (file) {
                    file.upload = dashboardService.upload(file, BASE_URL + '/page/upload');
                    file.upload.progress(function(evt) {
                        file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
                    }).success(function(response) {
                        if (response) {
                            if (tool.regex.image.test(file.type)) {
                                $scope.question.formData.title += '[FILE:IMAGE#' + response.data + ']';
                            } else if (tool.regex.audio.test(file.type)) {
                                $scope.question.formData.title += '[FILE:AUDIO#' + response.data + ']';
                            } else if (tool.regex.video.test(file.type)) {
                                $scope.question.formData.title += '[FILE:VIDEO#' + response.data + ']';
                            }
                        }
                    }).error(function(data) {
                        $scope.errFile = data;
                    });
                }
            };

            $scope.deleteTag = function(index) {
                var tagList = $scope.question.formData.tags;
                tagList.splice(index, 1);
                if (tagList.length == 1) {
                    $scope.validator.tag = false;
                }
            };

            function filterOptions(options) {
                var optionData = [];
                var correctCount = 0;
                for ( var i in options) {
                    if (options[i].correct == 1) {
                        correctCount++;
                    }
                    if (tool.regex.str_02.test(options[i].title)) {
                        optionData.push({
                            title : options[i].title,
                            correct : options[i].correct
                        });
                    }
                }
                return {
                    option : optionData.length > 0 ? optionData : undefined,
                    correctCount : correctCount
                };
            }

            function filterTags(tagArray) {
                var tagData = [];
                var tags = tagArray;
                for ( var i in tags) {
                    if (!tool.regex.str_01.test(tags[i].name)) {
                        continue;
                    }
                    var tag = {
                        id : tags[i].id,
                        name : tags[i].name
                    }
                    tagData.push(tag);
                }
                return tagData.length > 0 ? tagData : undefined;
            }

            $scope.check = function(option) {
                if (option.background == 'image-unchecked') {
                    option.background = 'image-checked';
                    option.correct = 1;
                } else {
                    option.background = 'image-unchecked';
                    option.correct = 0;
                }
            };

            $scope.focus = function() {
                $scope.question.isHasBorder = 'has-border';
            };

            $scope.selectedValue = function(tag) {
                $scope.question.formData.tagValue = tag.name;
                $scope.question.formData.tagId = tag.id;
            };

            $scope.blur = function() {
                var form = $scope.question.formData;
                var value = form.tagValue;
                var id = form.tagId;
                if (tool.regex.str_01.test(value)) {
                    var tags = form.tags;
                    var length = tags.length;
                    tags[length - 1].name = value;
                    tags[length - 1].visible = true;
                    tags[length - 1].id = id;
                    tags.push({
                        id : 0,
                        name : '',
                        visible : false
                    });
                    form.tagValue = '';
                    form.tagId = 0;
                }
                $scope.question.isHasBorder = 'no-border';
                $scope.question.searchTagList = [];
            };

            $scope.deleteRecord = function(index) {
                var options = $scope.question.formData.options;
                var length = options.length;
                if (length == 2) {
                    if (index == 0) {
                        options[1].visible = false;
                    } else if (index == 1) {
                        options[0].visible = false;
                    }
                }
                var option = options[index];
                var currentId = option.id;
                var currentCharacter = option.character;
                options.splice(index, 1);
                if (options.length < 2) {
                    $scope.validator.option = false;
                }
                setNextOption(index, currentId, currentCharacter);
            };

            $scope.change = function() {
                $scope.question.searchTagList = [];
                var value = $scope.question.formData.tagValue;
                var paramValue = escape(value.trim());
                if (paramValue.length > 0) {
                    questionService.getTag(paramValue).success(function(response) {
                        var data = JSON.parse(JSON.stringify(response));
                        if (data.length > 0) {
                            $.each(data, function(index, item) {
                                $scope.question.searchTagList.push({
                                    id : item.id,
                                    name : item.name
                                });
                            });
                        }
                    }).error(function(response) {
                        alert(JSON.stringify(response))
                    });
                }
            };

            function setNextOption(currentIndex, id, character) {
                var options = $scope.question.formData.options;
                if (currentIndex >= options.length) {
                    return;
                }
                var currentOption = options[currentIndex];
                var currentOptionId = currentOption.id;
                var currentOptionCharater = currentOption.character;
                currentOption.id = id;
                currentOption.character = character;
                setNextOption(currentIndex + 1, currentOptionId, currentOptionCharater);
            }

            $scope.cancel = function() {
                tool.confirmDialog('Are you sure to cancel?');
                var elem = $('a.closeId');
                elem.bind('click', function(){
                    if (this.id == 'confirmId') {
                        clean();
                        $timeout(function(){
                            $scope.validator.tag = false;
                            $scope.validator.title = false;
                            $scope.validator.answer = false;
                            $scope.validator.option = false;
                        });
                        elem.unbind('click');
                    }
                    $('#dialog').remove();
                });
            };

            window.onhashchange = function() {
                var hash = location.hash.replace("#/", "");
                var subHash = hash.substr(0, 1);
                var elem = $("#questionMenu").find("span[ui-sref='" + hash + "']");
                var newHash = hash.replace(subHash, subHash.toUpperCase());
                $scope.changeMenu(elem, hash, $scope, newHash);
                switch (hash) {
                case 'choice':
                    $scope.question.formData.answer = '';
                    break;
                case 'subjective':
                    $scope.question.formData.options = [{
                        correct : 0,
                        title : '',
                        id : 0,
                        character : 'A',
                        visible : false,
                        background : 'image-unchecked',
                    }];
                    break;
                }
            };

            $scope.changeMenu = function(elem, hash, scope, newHash) {
                if (elem) {
                    elem.find(".hand").removeClass('hidden');
                    elem.addClass('color-style01').removeClass('color-style02').css('width', '30%');
                    elem.find('.color-style01').removeClass('color-style01').addClass('color-style02');
                    var elements = elem.siblings('span');
                    elements.find(".hand").addClass('hidden');
                    elements.removeClass('color-style01').addClass('color-style02');
                    elements.find('.color-style02').removeClass('color-style02').addClass('color-style01');
                    elements.css('width', '14%');
                    $timeout(function() {
                        scope.question.routeTag = $.i18n.prop(hash);
                        scope.question.refView = STATIC_URL + 'static/html/question/show-' + hash + '.html';
                        scope.question.formData.questionTypeId = $(elem).attr('id');
                    });
                }
            };

            var clean = function() {
                $("#title").html('').removeClass('font-style07');
                $("#answer").html('');
                $("#sourceView").html('');
                $scope.question.formData.title = '';
                $scope.question.formData.answer = '';
                $scope.fileName = '';
                var value = $('.statictext').removeAttr('title');
                $scope.question.formData.tags = [{
                    id : 0,
                    name : '',
                    visible : false
                }];
                $scope.question.formData.options = [{
                    correct : 0,
                    title : '',
                    id : 0,
                    character : 'A',
                    visible : false,
                    background : 'image-unchecked',
                }]
            };

            $scope.createAgain = function() {
                var hash = location.hash.replace("#/", "");
                var validateData = filterData(hash);
                var isSubmit = validateData.validateResult;
                var formData = validateData.formData;
                if (isSubmit) {
                    questionService.submitForm(formData).success(function(response) {
                        setMessage(response);
                        $timeout(function() {
                            $scope.message = '';
                            clean();
                        }, 2000);
                    });
                }
            };
            $.i18n.properties({
                name : 'examMessage',
                path : RESOURCE_URL + '/i18n/',
                mode : 'map',
                language : LOCALE,
                callback : function() {
                    $scope.choiceLabel = $.i18n.prop('choice');
                    $scope.subjectiveLabel = $.i18n.prop('subjective');
                    $scope.answerLabel = $.i18n.prop('answer');
                    $scope.questionMsg = $.i18n.prop('question.message');
                }
            });

            var filterData = function(hash) {
                formData = $scope.question.formData;
                var validateResult = true;
                var form = {
                    questionTypeId : formData.questionTypeId,
                    author : "liming",
                    authorId : 1
                };
                switch (hash) {
                case 'choice':
                    if (!tool.regex.str_02.test(formData.title)) {
                        $scope.validator.title = true;
                        validateResult = false;
                        $('#titleMessage').attr('title', $.i18n.prop('question.titleWrongMsg'));
                    } else {
                        $scope.validator.title = false;
                        form.title = formData.title;
                        $('#titleMessage').removeAttr('title');
                    }
                    var validateOptions = filterOptions(formData.options);
                    if (validateOptions.option
                        && validateOptions.option.length == formData.options.length - 1
                        && validateOptions.correctCount > 0) {
                        $scope.validator.option = false;
                        form.options = validateOptions.option;
                        $('#optionMessage').removeAttr('title');
                    } else {
                        $scope.validator.option = true;
                        validateResult = false;
                        if (validateOptions.correctCount < 1) {
                            $('#optionMessage').attr('title', $.i18n.prop('question.choiceWrongMsg'));
                        } else {
                            $('#optionMessage').attr('title', $.i18n.prop('question.titleWrongMsg'));
                        }
                    }
                    var tags = filterTags(formData.tags)
                    if (tags && tags.length == formData.tags.length - 1) {
                        form.tags = tags;
                        $scope.validator.tag = false;
                        $('#tagMessage').removeAttr('title');
                    } else {
                        $scope.validator.tag = true;
                        validateResult = false;
                        $('#tagMessage').attr('title', $.i18n.prop('question.tagWrongMsg'));
                    }
                    break;
                case 'subjective':
                    if (!tool.regex.str_02.test(formData.title)) {
                        $scope.validator.title = true;
                        validateResult = false;
                        $('#titleMessage').attr('title', $.i18n.prop('question.titleWrongMsg'));
                    } else {
                        $scope.validator.title = false;
                        form.title = formData.title;
                        $('#titleMessage').removeAttr('title');
                    }
                    var tags = filterTags(formData.tags)
                    if (tags && tags.length == formData.tags.length - 1) {
                        $scope.validator.tag = false;
                        form.tags = tags;
                        $('#tagMessage').removeAttr('title');
                    } else {
                        $scope.validator.tag = true;
                        validateResult = false;
                        $('#tagMessage').attr('title', $.i18n.prop('question.titleWrongMsg'));
                    }

                    if (!tool.regex.str_02.test(formData.answer)) {
                        $scope.validator.answer = true;
                        validateResult = false;
                        $('#answerMessage').attr('title', $.i18n.prop('question.titleWrongMsg'));
                    } else {
                        $scope.validator.answer = false;
                        form.answer = formData.answer;
                        $('#answerMessage').removeAttr('title');
                    }
                    break;
                }
                return {
                    formData : form,
                    validateResult : validateResult
                }
            };

            $scope.$watch('question.formData.title', function() {
                var title = $scope.question.formData.title;
                $('#titleView').html(tool.replaceData(title));
            });
            $scope.$watch('question.formData.answer', function() {
                var answer = $scope.question.formData.answer;
                $('#answerView').html(tool.replaceData(answer));
            });
            $scope.optionTextChanged = function(option) {
                $('#' + option.id).html(tool.replaceData(option.title));
           };
            $scope.create = function() {
                var hash = location.hash.replace("#/", "");
                var validateData = filterData(hash);
                var isSubmit = validateData.validateResult;
                var formData = validateData.formData;
                if (isSubmit) {
                    questionService.submitForm(formData).success(function(response) {
                        setMessage(response);
                        $timeout(function() {
                            location.href = BASE_URL + '/page/question/question-list';
                        }, 2000);
                    });
                }
            };

            var setMessage = function(response) {
                var title = response.data.title;
                var name = response.data.name;
                var answer = response.data.answer;
                var option = response.data.option;
                var tag = response.data.tag;
                if (title) {
                    $scope.message = title;
                } else if (name) {
                    $scope.message = name;
                } else if (answer) {
                    $scope.message = answer;
                } else if (option) {
                    $scope.message = option;
                } else if (tag) {
                    $scope.message = tag;
                } else {
                    $scope.message = response.data;
                    $scope.visibleMsg = false;
                }
            };

            $scope.addBtn = function(option) {
                var id = 1 + parseInt(option.id);
                var options = $scope.question.formData.options;
                if (id >= options.length && id < 26) {
                    options.push({
                        id : id,
                        character : String.fromCharCode(id + 65),
                        visible : false,
                        background : 'image-unchecked',
                        correct : 0,
                        title : ''
                    });
                    options[id - 1].visible = true;
                }
            };
        }]);
    });