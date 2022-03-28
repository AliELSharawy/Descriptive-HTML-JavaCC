package egtry.dsl;

public class HtmlTagsFactory {
    private final String tagType;
    private final String src;
    private final String fontFamily;
    private final String content;
    private final String color;
    private final String href;

    public HtmlTagsFactory(String tagType, String src, String fontFamily, String content, String color, String href) {
        this.tagType = tagType;
        this.src = src;
        this.fontFamily = fontFamily;
        this.content = content;
        this.color = color;
        this.href = href;
    }

    public String createTag() {
        return switch (tagType) {
            case "img" -> createImgTag();
            case "p" -> createParagraphTag();
            case "h1" -> createHeaderTag();
            case "a" -> createUrlTag();
            default -> "";
        };
    }

    private String createImgTag() {
        return "<img src=\""+ src +"\"" + "/>";
    }

    private String createHeaderTag() {
        return "<h1 " + getStyle() + ">" + content + "</h1>";
    }

    private String createParagraphTag() {
        return "<p " + getStyle() + ">" + content + "</p>";
    }

    private String createUrlTag() {
        String url = "href=\"" + href + "\"";
        return "<a " + url + " " + getStyle() + ">" + content + "</a>";
    }

    private String getStyle() {
        String style = "";
        if (!fontFamily.isEmpty())
            style = "font-family:" + fontFamily + ";";
        if(!color.isEmpty())
        	style += "color:\"" + color + "\";";
        if(!style.isEmpty())
            style = "style=\"" + style + "\"";
        return style;
    }

}

