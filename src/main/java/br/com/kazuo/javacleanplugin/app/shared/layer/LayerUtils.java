package br.com.kazuo.javacleanplugin.app.shared.layer;

import br.com.kazuo.javacleanplugin.app.shared.cache.ProjectCache;

import java.util.*;

public class LayerUtils {

    public static String getLayerImport(String layer, Map<String, String> mainLayer, Boolean asPath, Boolean fullpath, Boolean isTest) {
        Boolean hasParent = true;
        List<String> relLayers = new ArrayList<>();
        relLayers.add(layer);
        while(hasParent) {
            String parent = mainLayer.get(relLayers.get(relLayers.size()-1));
            hasParent = Objects.nonNull(parent);
            if (hasParent) {
                relLayers.add(parent);
            }
        }
        // Collections.sort(relLayers, Collections.reverseOrder());
        StringBuilder relPath = new StringBuilder()
                .append(asPath ? ProjectCache.getInstance().getGroupIdAsPath(fullpath, isTest) : ProjectCache.getInstance().getGroupId());
        for(int i = relLayers.size()-1; i >= 0 ; i-- ) {
            relPath.append(asPath ? "\\": ".").append(relLayers.get(i));
        }
        return relPath.toString();
    }

}
