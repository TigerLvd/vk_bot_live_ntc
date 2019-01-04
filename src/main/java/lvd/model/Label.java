package lvd.model;

public enum Label {
    TIME_TABLE("Расписание"),
    MASTER_CLASSES("Мастер-классы"),
    SPEAKERS("Спикеры"),
    CONTACTS("Контакты"),
    PHOTOS("Фотки"),
    NEWS("Объявления"),
    FOOD("Еда");

    private final String title;

    Label(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static boolean contains(String str) {
        for (Label label : values()) {
            if (label.getTitle().equals(str)) {
                return true;
            }
        }

        return false;
    }
}