package com.javafortesters.pulp.html.templates;

import com.javafortesters.pulp.reader.ResourceReader;

public class FilledHTMLTemplate {
    private final String appversion;

    public FilledHTMLTemplate(final String appversion) {
        this.appversion = appversion;
    }

    public String searchResultMessage(final String message) {

        final MyTemplate template = new HtmlTemplates(appversion).getSearchResultMessage();
        template.replace("!!MESSAGE!!", message);

        return template.toString();
    }

    public String li(final String li_text, final String id, final String theClass) {
        final MyTemplate template = new HtmlTemplates(appversion).getLi();
        template.replace("!!TEXT!!", li_text);
        template.replace("!!ID!!", id);
        template.replace("!!CLASS!!", theClass);

        return template.toString();
    }

    public String error(final String errorMessage) {
        final MyTemplate template = new HtmlTemplates(appversion).getErrorMessage();
        template.replace("!!MESSAGE!!", errorMessage);
        return template.toString();
    }

    public String namedNewTabLink(final String href, final String linktext, final String name) {
        MyTemplate template = new HtmlTemplates(appversion).getNamedNewTabLink();
        template.replace("!!HREF!!", href);
        template.replace("!!LINKTEXT!!", linktext);
        template.replace("!!NAME!!", name);
        return template.toString();

    }

    public String table(final String bookslisttable) {
        MyTemplate template = new HtmlTemplates(appversion).getTableTag();
        template.replace("!!ID!!", bookslisttable);
        template.replace("!!NAME!!", bookslisttable);
        return template.toString();

    }

    public String span(final String id, final String text) {
        MyTemplate template = new HtmlTemplates(appversion).getSpanTag();
        template.replace("!!ID!!", id);
        template.replace("!!TEXT!!", text);
        return template.toString();
    }

    public String ul(final String id) {
        MyTemplate template = new HtmlTemplates(appversion).getUlTag();
        template.replace("!!ID!!", id);
        return template.toString();
    }

    public String deleteAuthorButton(String authorId, String deleteButtonText, String authorName) {
        return deleteButton("delete-author.html", authorId, deleteButtonText, authorName);
    }

    public String deleteBookButton(final String id, final String buttonText, final String title) {
        return deleteButton("delete-book.html", id, buttonText, title);
    }

    public String deleteSeriesButton(final String id, final String buttonText, final String seriesTitle) {
        return deleteButton("delete-series.html", id, buttonText, seriesTitle);
    }

    public String deletePublisherButton(final String id, final String buttonText, final String publisherName) {
        return deleteButton("delete-publisher.html", id, buttonText, publisherName);
    }

    public String deleteButton(final String template_name, final String id, final String buttonText, final String title) {

        if(appversion.contentEquals("v001")){
            return "";
            // List button delete only appeared in version 2
        }

        String pageToRender = new ResourceReader().asString("/web/apps/pulp/" + appversion + "/page-template/snippets/delete/" + template_name);

        MyTemplate template = new MyTemplate(pageToRender);
        template.replace("!!ID!!", id);
        template.replace("!!DELETEBUTTONTEXT!!", buttonText);
        template.replace("!!TEXT!!", title);

        return template.toString();
    }

}
