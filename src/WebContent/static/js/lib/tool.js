define(['jQuery'], function($) {
    return {
        replaceData : function(data){
            var array = this.uniqueArray(data.match(this.regex.fileNameFormat));
            if (array && array.length > 0) {
                for (index in array) {
                    var elem = array[index];
                    var source;
                    var fileName = elem.substring(elem.indexOf('#') + 1, elem.indexOf(']'));
                    var playUrl = RESOURCE_URL + '/' + fileName;
                    if (this.regex.imageType.test(elem)) {
                        source = "<img src='" + RESOURCE_URL + "/" + fileName + "' />"
                        var regex = new RegExp('\\[FILE:IMAGE#' + fileName + '\\]', 'g');
                        data = data.replace(regex, source);
                    } else if (this.regex.videoType.test(elem)) {
                        source = "<div title='click to play video' class='color-style01 circle hand'><a href='" + playUrl + "'  target='_blank' class='hand triangle-right'></a></div>";
                        var regex = new RegExp('\\[FILE:VIDEO#' + fileName + '\\]', 'g');
                        data = data.replace(regex, source);
                    } else if (this.regex.audioType.test(elem)) {
                        source = "<div title='click to play voice' class='color-style01 circle hand'><a href='" + playUrl + "' target='_blank' class='hand triangle-right'></a></div>";
                        var regex = new RegExp('\\[FILE:AUDIO#' + fileName + '\\]', 'g');
                        data = data.replace(regex, source);
                    }
                }
            }
            return data;
        },
        confirmDialog : function(message) {
            var sourceData = "<div id='dialog' class='dialog-container'><div class='dialog'><div class='header'><span>Dialog:</span>"
                + "<a id='closeId' class='closeId dialog-close'>X</a></div><div class='infor'><div>" + message + "</div></div>"
                + "<div class='operator'><a id='confirmId' class='closeId'>Sure</a><a id='cancelId' class='closeId'>Cancel</a></div></div></div>";
            $('body').append(sourceData);
        },
        autoTextArea : function(elem, extra, maxHeight) {
            extra = extra || 0;
            var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window, isOpera = !!window.opera
                && !!window.opera.toString().indexOf('Opera'), addEvent = function(type, callback) {
                elem.addEventListener ? elem.addEventListener(type, callback, false) : elem.attachEvent('on' + type,
                    callback);
            }, getStyle = elem.currentStyle ? function(name) {
                var val = elem.currentStyle[name];
                if (name === 'height' && val.search(/px/i) !== 1) {
                    var rect = elem.getBoundingClientRect();
                    return rect.bottom - rect.top - parseFloat(getStyle('paddingTop'))
                        - parseFloat(getStyle('paddingBottom')) + 'px';
                };
                return val;
            } : function(name) {
                return getComputedStyle(elem, null)[name];
            }, minHeight = parseFloat(getStyle('height'));
            elem.style.resize = 'none';
            var change = function() {
                var scrollTop, height, padding = 0, style = elem.style;
                if (elem._length === elem.value.length)
                    return;
                elem._length = elem.value.length;
                if (!isFirefox && !isOpera) {
                    padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
                };
                scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
                elem.style.height = minHeight + 'px';
                if (elem.scrollHeight > minHeight) {
                    if (maxHeight && elem.scrollHeight > maxHeight) {
                        height = maxHeight - padding;
                        style.overflowY = 'auto';
                    } else {
                        height = elem.scrollHeight - padding;
                        style.overflowY = 'hidden';
                    };
                    style.height = height + extra + 'px';
                    scrollTop += parseInt(style.height) - elem.currHeight;
                    document.body.scrollTop = scrollTop;
                    document.documentElement.scrollTop = scrollTop;
                    elem.currHeight = parseInt(style.height);
                };
            };
            addEvent('propertychange', change);
            addEvent('input', change);
            addEvent('focus', change);
            change();
        },
        regex : {
            str_01 : /^\S{1}$|^\S{2}$|^\S.{1,48}\S$/,
            str_02 : /^\S{1}$|^\S{2}$|^\S.{1,2998}\S$/,
            image : /^(image)/,
            video : /^(video)/,
            audio : /^(audio)/,
            fileNameFormat : /\[FILE:\w+#\d{4}\/[1-12]\/\S{1,25}\.\S{3,4}\]/g,
            imageType : /^\[FILE:IMAGE#\S+\]$/,
            audioType : /^\[FILE:AUDIO#\S+\]$/,
            videoType : /^\[FILE:VIDEO#\S+\]$/
        },
        uniqueArray : function unique(arr) {
            if (!arr) {
                return;
            }
            var n = {}, r = [];
            for (var i = 0; i < arr.length; i++) {
                if (!n[arr[i]]) {
                    n[arr[i]] = true;
                    r.push(arr[i]);
                }
            }
            return r;
        },
        copyToClipboard : function copy_code(copyText) {
            if (window.clipboardData) {
                window.clipboardData.setData("Text", copyText)
            } else {
                var flashcopier = 'flashcopier';
                if (!document.getElementById(flashcopier)) {
                    var divholder = document.createElement('div');
                    divholder.id = flashcopier;
                    document.body.appendChild(divholder);
                }
                document.getElementById(flashcopier).innerHTML = '';
                var src = STATIC_URL + 'static/tool/clipboard.swf';
                var divinfo = '<embed src="' + src + '" FlashVars="clipboard=' + encodeURIComponent(copyText)
                    + '" width="0" height="0" type="application/x-shockwave-flash"></embed>';
                document.getElementById(flashcopier).innerHTML = divinfo;
            }
        },
        VoicePlayer : {
            player : null,
            player_id : 'voice_player',
            voice_box_id : 'voice_box',
            ready : function() {
                if (VoicePlayer.player !== null) {
                    return;
                }
                var voice_box = document.createElement('div');
                voice_box.id = VoicePlayer.voice_box_id;
                if (!-[1, ]) {
                    voice_box.innerHTML = '<object width="1" height="1" type="application/x-shockwave-flash" data="soundPlay.swf" id="'
                        + VoicePlayer.player_id
                        + '" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" style="visibility: visible;"><param name="movie" value="soundPlay.swf"/></object>';
                } else {
                    voice_box.innerHTML = '<object width="1" height="1" type="application/x-shockwave-flash" data="soundPlay.swf" id="'
                        + VoicePlayer.player_id + '" style="visibility: visible;"></object>';
                }
                document.body.appendChild(voice_box);
                if (typeof swfobject !== 'undefined') {
                    VoicePlayer.player = swfobject.getObjectById(VoicePlayer.player_id);
                }
            },
            play : function(soundUrl) {
                if (typeof soundUrl === 'undefined')
                    return;
                if (VoicePlayer.player === null) {
                    VoicePlayer.ready();
                }
                VoicePlayer.player.playSound(soundUrl);
            }
        }
    }
});