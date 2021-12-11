package br.com.kazuo.javacleanplugin.app.dataprovider.io.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileUseCase implements IFileUsecase {

    private static final String FILE_FORMAT = "UFT-8";

    @Override
    public void createPaths(List<String> paths) throws IOException {
        for(String path: paths) {
            System.out.println(String.format("creating structure: %s", path));
            Objects.nonNull(Files.createDirectories(Paths.get(path)));
        }
    }

    @Override
    public void writeFile(String fullpathfile, List<String> lines) throws IOException {
        this.excludeFileIfExists(fullpathfile);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fullpathfile, true), FILE_FORMAT));
        for (String l: lines) {
            writer.write(l);
        }
        writer.close();
    }

    private void excludeFileIfExists(String fullpathfile) throws IOException {
        File file = new File(fullpathfile);
        if (file.exists()) {
            file.delete();
        }
    }

}
