package com.denormans.googleanalyticsgwt.api.support;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.event.dom.client.HasLoadHandlers;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

public class ScriptWidget extends Widget implements HasLoadHandlers {
    public ScriptWidget() {
        setElement(Document.get().createScriptElement());
    }

    public ScriptElement getScriptElement() {
        return ScriptElement.as(getElement());
    }

    public boolean isAsync() {
        return Boolean.parseBoolean(getElement().getAttribute("async"));
    }

    public void setAsync(boolean async) {
        getElement().setAttribute("async", Boolean.toString(async));
    }

    public String getSrc() {
        return getScriptElement().getSrc();
    }

    public void setSrc(String src) {
        getScriptElement().setSrc(src);
    }

    public boolean getDefer() {
        return Boolean.parseBoolean(getScriptElement().getDefer());
    }

    public void setDefer(boolean defer) {
        getScriptElement().setDefer(Boolean.toString(defer));
    }

    public String getType() {
        return getScriptElement().getType();
    }

    public void setType(String type) {
        getScriptElement().setType(type);
    }

    public String getText() {
        return getScriptElement().getText();
    }

    public void setText(String text) {
        getScriptElement().setText(text);
    }

    @Override
    public HandlerRegistration addLoadHandler(LoadHandler handler) {
        return addDomHandler(handler, LoadEvent.getType());
    }
}
