package br.com.kazuo.javacleanplugin.app.shared.cache;

import br.com.kazuo.javacleanplugin.app.core.entity.BaseLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LayerCache {
    private static LayerCache instance;

    private List<BaseLayer> layers;

    private LayerCache() {}

    public static LayerCache getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LayerCache();
        }
        return instance;
    }

    public void setLayers(List<BaseLayer> layers) {
        this.layers = layers;
        this.initLayersList();
    }

    public List<BaseLayer> getLayers() {
        this.initLayersList();
        return this.layers;
    }

    public void addLayer(String layer, String parent) {
        this.initLayersList();
        this.layers.add(new BaseLayer(layer, parent));
    }

    private void initLayersList() {
        if (Objects.isNull(this.layers)) {
            this.layers = new ArrayList<>();
        }
    }
}
