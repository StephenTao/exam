package com.augmentum.exam;


public class Constants {

    public static final String EMPTY_STRING = "";
    public static final String UTF_8 = "UTF-8";
    public static final String QUESTION_ID = "questionId";
    public static final String TAG_ID = "tagId";
    public static final String EXAMINEE_ID = "examineeId";
    public static final String PAPER_QUESTION_ID = "paperQuestionId";
    public static final String USER_ID = "userId";
    public static final String SHOW_SIZE_ID = "showSizeId";
    public static final String SHOW_FIELD_ID = "showFieldId";
    public static final String SPLIT_STRIKE = "-";
    public static final String SPLIT_COMMA = ",";
    public static final String LANGUAGE_EN_US = "en_US";
    public static final String LANGUAGE_ZH_CN = "zh_CN";
    public static final String LANGUAGE = "language";
    public static final String TEST_PAGE = "http://localhost:8080/exam/static/test.html";
    public static final String PAGE_TITLE = "pageTitle";
    public static final String TITLE_USER_LOGIN = "userLoginTitle";
    public static final String TITLE_DASHBOARD = "dashboardTitle";

    public static final String CREATE_QUESTION_PAGE = "question/create-question";
    public static final String CREATE_EXAM_PAGE = "exam/create-exam";
    public static final String CREATE_TAG_PAGE = "tag/create-tag";
    public static final String QUESTION_LIST_PAGE = "question/question-list";
    public static final String EXAM_LIST_PAGE = "exam/exam-list";
    public static final String TAG_LIST_PAGE = "tag/tag-list";
    public static final String MY_QUESTION_PAGE = "question/myquestion";
    public static final String MY_EXAM_PAGE = "exam/myexam";
    // FILE REGEX
    public static final String REGEX_IMG = "\\[FILE:IMAGE#\\d{4}\\/\\d{2}\\/\\S{1,25}\\.\\S{3,4}\\]";
    public static final String REGEX_AUDIO = "\\[FILE:AUDIO#\\d{4}\\/\\d{2}\\/\\S{1,25}\\.\\S{3,4}\\]";
    public static final String REGEX_VIDEO = "\\[FILE:VIDEO#\\d{4}\\/\\d{2}\\/\\S{1,25}\\.\\S{3,4}\\]";
    public static final String REGEX_FILE = "\\[FILE:\\w+#\\d{4}\\/\\d{2}\\/\\S{1,25}\\.\\S{3,4}\\]";

    public static final String DEVELOPER_PAGE = "developer/developer";
    public static final String EXAM_PAGE = "exam/exam";
    public static final String LOG_ERROR = "error";
    public static final String SUCCESSFUL = "Successful";

    public static final String QUESTION_ANSWER = "answer";
    public static final String QUESTION_ANSWER_CONTENT = "The answer can't be empty !";

    public static final String QUESTION_OPTION = "option";
    public static final String QUESTION_OPTION_CONTENT = "The option can't be empty !";

    public static final String TAG = "tag";
    public static final String TAG_CONTENT = "The tag can't be empty !";

    public static final String CAS_LOGIN_OPEN = "cas.validation.is.open";
    public static final String CAS_LOGOUT_URL = "cas.logout.url";
    public static final String KEY_ERROR_CAS_LOGIN_OPEN = "youShouldLoginViaCAS";
    public static final String RESOURCE_URL = "resourceURL";

}
