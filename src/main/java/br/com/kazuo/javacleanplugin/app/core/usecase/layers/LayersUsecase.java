package br.com.kazuo.javacleanplugin.app.core.usecase.layers;

import br.com.kazuo.javacleanplugin.app.dataprovider.io.file.FileUseCase;
import br.com.kazuo.javacleanplugin.app.shared.layer.LayerUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LayersUsecase {

    private Map<String, String> mainLayer;

    public LayersUsecase() throws IOException {
        this.createLayers();
        this.preparePathStructure();
    }

    private void createLayers() {
        mainLayer = new HashMap<>();
        mainLayer.put("config", null);
        mainLayer.put("shared", null);
        mainLayer.put("dataprovider", null);
        mainLayer.put("core", null);
        mainLayer.put("entity", "core");
        mainLayer.put("usecase", "core");
    }

    private void preparePathStructure() throws IOException {
        FileUseCase fileUseCase = new FileUseCase();
        fileUseCase.createPaths(mainLayer.entrySet().stream().map(e -> LayerUtils.getLayerImport(e.getKey(), mainLayer, true, true, false)).collect(Collectors.toList()));
        fileUseCase.createPaths(mainLayer.entrySet().stream().map(e -> LayerUtils.getLayerImport(e.getKey(), mainLayer, true, true, true)).collect(Collectors.toList()));
    }

}
