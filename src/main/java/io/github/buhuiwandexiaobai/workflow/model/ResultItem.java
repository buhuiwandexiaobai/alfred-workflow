package io.github.buhuiwandexiaobai.workflow.model;

/**
 * @author zhaobin
 * @date 2021/7/12 21:52
 */
public class ResultItem {
    private String uid;
    private String arg;
    private boolean valid;
    private String icon;
    private String title;
    private String subtitle;



    public String getUid() {
        return uid;
    }

    public String getArg() {
        return arg;
    }

    public boolean isValid() {
        return valid;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String toString() {
        return "<item uid = \"" + uid + "\" arg = \"" + arg + "\">"
                + "<title>" + title + "</title>"
                + "<subtitle>" + subtitle + "</subtitle>"
                + "<icon>" + icon + "</icon>"
                + "</item>";
    }

    public static final class ResultItemBuilder {
        private String uid;
        private String arg;
        private boolean valid;
        private String icon;
        private String title;
        private String subtitle;

        private ResultItemBuilder() {
        }

        public static ResultItemBuilder aResultItem() {
            return new ResultItemBuilder();
        }

        public ResultItemBuilder setUid(String uid) {
            this.uid = uid;
            return this;
        }

        public ResultItemBuilder setArg(String arg) {
            this.arg = arg;
            return this;
        }

        public ResultItemBuilder setValid(boolean valid) {
            this.valid = valid;
            return this;
        }

        public ResultItemBuilder setIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public ResultItemBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ResultItemBuilder setSubtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public ResultItem build() {
            ResultItem resultItem = new ResultItem();
            resultItem.valid = this.valid;
            resultItem.title = this.title;
            resultItem.icon = this.icon;
            resultItem.uid = this.uid;
            resultItem.arg = this.arg;
            resultItem.subtitle = this.subtitle;
            return resultItem;
        }
    }
}
