package br.com.kazuo.javacleanplugin.app.core.entity;

import br.com.kazuo.javacleanplugin.app.shared.cache.ProjectCache;

import java.util.Objects;

public class BaseLayer {

    private String parent;
    private String layer;

    public BaseLayer(String layer, String parent) {
        this.layer = layer;
        this.parent = parent;
    }

    public Boolean isParent() {
        return Objects.isNull(this.parent);
    }

}
