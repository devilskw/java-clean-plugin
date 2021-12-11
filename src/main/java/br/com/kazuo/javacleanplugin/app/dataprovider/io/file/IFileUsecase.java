package br.com.kazuo.javacleanplugin.app.dataprovider.io.file;

import java.io.IOException;
import java.util.List;

public interface IFileUsecase {
    void createPaths(List<String> paths) throws IOException;
    void writeFile(String fullpathfile, List<String> lines) throws IOException;
}
