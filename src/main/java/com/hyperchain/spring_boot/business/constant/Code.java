package com.hyperchain.spring_boot.business.constant;

/**
 * Created by superlee on 2017/11/6.
 */
public enum
Code {
    //通用部分
    UNDEFINED(-1, "未定义"),
    SUCCESS(0, "成功"),
    FALSE(1, "失败"),
    UPLOAD_FILE_ERROR(1002, "上传文件失败"),
    DELETE_FILE_ERROR(1002, "删除文件失败"),


    USER_EXISTED(2001, "用户已经存在"),
    USER_UNEXISTED(2002, "用户不存在"),
    USER_LOGINED(2003, "已在其他地方登录"),
    EMAIL_BIND(2005, "邮箱已被绑定"),
    PHONE_BIND(2006, "手机已被绑定"),
    PASSWORD_ERROR(2004, "密码不一致"),

    GRAPH_CODE_CREATE_ERROR(1710, "图片验证码生成错误"),
    GRAPH_CODE_VERIFY_ERROR(1711, "验证码错误"),
    PHONE_CODE_CREATE_FREQUENT(1712, "验证码获取太频繁"),
    PHONE_CODE_VERIFY_ERROR(1713, "手机验证码错误"),
    PHONE_CODE_EXPIRE_TIME(1714, "验证码过期，请重新获取"),
    PHONE_CODE_SEND_ERROR(1715, "手机验证码发送异常"),
    CODE_CREATE_FREQUENT(1716, "验证码获取太频繁"),
    MAIL_SEND_ERROR(1717, "邮件发送失败"),
    MAIL_CODE_VERIFY_ERROR(1718, "邮箱验证码错误"),
    MAIL_CODE_EXPIRE_TIME(1719, "验证码过期，请重新获取"),
    MAIL_CODE_SEND_ERROR(1720, "邮箱验证码发送异常"),
    MAIL_ERROR(1721, "邮件发送异常"),
    MAIL_NO_EXIST(1722, "未知邮箱"),
    MAIL_FORMAT_ERROR(1723, "邮箱格式问题"),

    QUESTION_DONE(1801, "题目已经关闭"),
    ANSWER_UNEXISTED(1802, "答案不存在"),
    QUESTION_UNEXISTED(1803, "题目不存在"),
    QUESTION_DELETED_AUTH(1804, "没有权限删除该题目"),
    QUESTION_DOING(1805, "问题处理中"),
    QUESTION_DEALED(1806, "问题已处理"),

    ANSWER_ENSURED(1807, "答案已经采纳或推荐"),
    ANSWER_ADOPT_TWICE(1808, "一个问题只能采纳一个答案"),
    ANSWER_RECOMMEND_TWICE(1809, "一个问题只能推荐一个答案"),

    PARAMETER_ERROR(8001, "参数校验异常"),

    PERMISSION_DENIED(9001, "权限拒绝"),
    UNKNOWN_ABNORMAL(9002, "未知异常"),
    INVALID_USER(9003, "账户不存在，该用户可能未注册或已失效"),
    ACCOUNT_KEY_EMPTY(9004, "用户名为空"),
    ACCOUNT_ALREADY_EXIST(9005, "用户名已存在"),
    ERROR_PASSWORD(9006, "密码错误"),
    PASSWORD_ERROR_TIME_OVER(9007, "错误次数超过限制"),
    ACCOUNT_STILL_LOCK(9008, "账户仍处于锁定状态"),

    TOKEN_FORMAT_ERROR(9009, "token格式错误，不是有效token"),
    TOKEN_INVALID(9010, "token过期"),
    TOKEN_CRYPT_ERROR(9011, "token加解密异常"),

    HYPERCHAIN_ERROR(9100, "区块链异常"),

    JSON_TRANSFER_ERROR(9200, "JSON转化异常"),

    CLIENT_NOT_REGISTER(9300, "业务系统未注册"),
    CLIENT_ALREADY_REGISTER(9301, "业务系统已注册"),

    CLIENT_ROLE_NOT_EXIST(9400, "该业务系统该角色不存在"),

    SYSTEM_ERROR(9999, "系统异常，请稍后重试");


    private int code;
    private String msg;

    // 构造方法
    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static String getMsgByCodeInt(int codeInt) {
        for (Code e : Code.values()) {
            if (e.getCode() == codeInt) {
                return e.msg;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }

    public static Code getCodeByCodeInt(int codeInt) {
        for (Code code : Code.values()) {
            if (code.getCode() == codeInt) {
                return code;
            }
        }
        throw new IllegalArgumentException("未定义的code码:" + codeInt);
    }


}
