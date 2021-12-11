package br.com.kazuo.javacleanplugin.app.shared.cache;

import org.apache.maven.project.MavenProject;

import java.util.Objects;

public class ProjectCache {
    private static ProjectCache instance;

    private MavenProject project;
    private String appType;

    private ProjectCache() {}

    public static ProjectCache getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ProjectCache();
        }
        return instance;
    }

    public void setProject(MavenProject project) {
        this.project = project;
    }

    public MavenProject getProject() {
        return project;
    }

    public void setAppType(String appType){
        this.appType = appType;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getSourceDir() {
        return project.getBuild().getSourceDirectory();
    }

    public String getTestDir() {
        return project.getBuild().getTestSourceDirectory();
    }

    public String getResourceDir() {
        return project.getBuild().getResources().size() > 0 ? project.getBuild().getResources().get(0).getDirectory() : null;
    }

    public String getJavaVersion(String defaultVersion) {
        return Objects.isNull(project.getProperties().getProperty("java.version")) ? defaultVersion : project.getProperties().getProperty("java.version");
    }

    public String getGroupId() {
        return project.getGroupId();
    }

    public String getGroupIdAsPath(Boolean fullpath, Boolean isTest) {
        String relPath  = new StringBuilder()
                .append("\\")
                .append(project.getGroupId().replace(".", "\\"))
                .append("\\")
                .append(appType)
                .toString();

        StringBuilder basePath = new StringBuilder()
                .append(isTest ? project.getBuild().getTestSourceDirectory() : project.getBuild().getSourceDirectory() );

        return fullpath ? basePath.append(relPath).toString() : relPath;
    }

    public String getArtifactId() {
        return project.getArtifactId();
    }

}
