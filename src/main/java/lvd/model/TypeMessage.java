package lvd.model;

public enum TypeMessage {
    CONFIRMATION("confirmation", "проверка", null),

    MESSAGE_NEW("message_new", "входящее сообщение", GroupTypeMessage.MESSAGE),

    MESSAGE_REPLY("message_reply", "новое исходящее сообщение", GroupTypeMessage.MESSAGE),

    MESSAGE_EDIT("message_edit", "редактирование сообщения", GroupTypeMessage.MESSAGE),

    MESSAGE_ALLOW("message_allow", "подписка на сообщения от сообщества", GroupTypeMessage.MESSAGE),

    MESSAGE_DENY("message_deny", "новый запрет сообщений от сообщества", GroupTypeMessage.MESSAGE),

    PHOTO_NEW("photo_new", "добавление фотографии", GroupTypeMessage.PHOTO),

    PHOTO_COMMENT_NEW("photo_comment_new", "добавление комментария к фотографии", GroupTypeMessage.PHOTO),

    PHOTO_COMMENT_EDIT("photo_comment_edit", "редактирование комментария к фотографии", GroupTypeMessage.PHOTO),

    photo_comment_restore("photo_comment_restore", "восстановление комментария к фотографии", GroupTypeMessage.PHOTO),

    PHOTO_COMMENT_DELETE("photo_comment_delete", "удаление комментария к фотографии", GroupTypeMessage.PHOTO),

    AUDIO_NEW("audio_new", "добавление аудио", GroupTypeMessage.AUDIO),

    VIDEO_NEW("video_new", "добавление аудио", GroupTypeMessage.VIDEO),

    VIDEO_COMMENT_NEW("video_comment_new", "комментарий к видео", GroupTypeMessage.VIDEO),

    VIDEO_COMMENT_EDIT("video_comment_edit", "редактирование комментария к видео", GroupTypeMessage.VIDEO),

    VIDEO_COMMENT_RESTORE("video_comment_restore", "восстановление комментария к видео", GroupTypeMessage.VIDEO),

    VIDEO_COMMENT_DELETE("video_comment_delete", "удаление комментария к видео", GroupTypeMessage.VIDEO),

    WALL_POST_NEW("wall_post_new", "запись на стене", GroupTypeMessage.WALL_POST),

    WALL_REPOST("wall_repost", "репост записи из сообщества", GroupTypeMessage.WALL_POST),

    WALL_REPLY_NEW("wall_reply_new", "добавление комментария на стене", GroupTypeMessage.WALL_REPLY),

    WALL_REPLY_EDIT("wall_reply_edit", "редактирование комментария на стене", GroupTypeMessage.WALL_REPLY),

    WALL_REPLY_RESTORE("wall_reply_restore", "восстановление комментария на стене", GroupTypeMessage.WALL_REPLY),

    WALL_REPLY_DELETE("wall_reply_delete", "удаление комментария на стене", GroupTypeMessage.WALL_REPLY),

    BOARD_POST_NEW("board_post_new", "создание комментария в обсуждении", GroupTypeMessage.BOARD_POST),

    BOARD_POST_EDIT("board_post_edit", "редактирование комментария", GroupTypeMessage.BOARD_POST),

    BOARD_POST_RESTORE("board_post_restore", "восстановление комментария", GroupTypeMessage.BOARD_POST),

    BOARD_POST_DELETE("board_post_delete", "удаление комментария в обсуждении", GroupTypeMessage.BOARD_POST),

    MARKET_COMMENT_NEW ("market_comment_new", "новый комментарий к товару", GroupTypeMessage.MARKET),

    MARKET_COMMENT_EDIT ("market_comment_edit", "редактирование комментария к товару", GroupTypeMessage.MARKET),

    MARKET_COMMENT_RESTORE ("market_comment_restore", "восстановление комментария к товару", GroupTypeMessage.MARKET),

    MARKET_COMMENT_DELETE ("market_comment_delete", "удаление комментария к товару", GroupTypeMessage.MARKET),

    GROUP_LEAVE ("group_leave", "удаление участника из сообщества", GroupTypeMessage.USERS),

    GROUP_JOIN ("group_join", "добавление участника или заявки на вступление в сообщество", GroupTypeMessage.USERS),

    USER_BLOCK ("user_block", "добавление пользователя в чёрный список", GroupTypeMessage.USERS),

    USER_UNBLOCK ("user_unblock", "удаление пользователя из чёрного списка", GroupTypeMessage.USERS),

    POLL_VOTE_NEW ("poll_vote_new", "добавление голоса в публичном опросе", GroupTypeMessage.OTHER),

    GROUP_OFFICERS_EDIT ("group_officers_edit", "редактирование списка руководителей", GroupTypeMessage.OTHER),

    GROUP_CHANGE_SETTINGS ("group_change_settings ", "изменение настроек сообщества", GroupTypeMessage.OTHER),

    GROUP_CHANGE_PHOTO ("group_change_photo", "изменение главного фото", GroupTypeMessage.OTHER),

    VKPAY_TRANSACTION ("vkpay_transaction", "платёж через VK Pay", GroupTypeMessage.OTHER);

    private final String title;

    private final String value;

    private final GroupTypeMessage group;

    TypeMessage(String title, String value, GroupTypeMessage group) {
        this.title = title;
        this.value = value;
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public GroupTypeMessage getGroup() {
        return group;
    }
}