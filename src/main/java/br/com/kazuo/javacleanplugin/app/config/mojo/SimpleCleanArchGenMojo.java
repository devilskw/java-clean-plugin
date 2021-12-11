package br.com.kazuo.javacleanplugin.app.config.mojo;

import br.com.kazuo.javacleanplugin.app.core.usecase.layers.LayersUsecase;
import br.com.kazuo.javacleanplugin.app.shared.cache.ProjectCache;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.IOException;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.POST_SITE)
public class SimpleCleanArchGenMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    @Parameter(defaultValue = "app", required = false)
    private String appType;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("Thanks for trying my simple Clean architecture plugin!");
        System.out.println("Reading your project");
        ProjectCache.getInstance().setProject(project);
        ProjectCache.getInstance().setAppType(appType);
        System.out.println("Preparing clean arch directories structure");
        try {
            new LayersUsecase();
        } catch (IOException ex) {
            throw new MojoExecutionException(ex.getMessage());
        }
        System.out.println("Clean architecture plugin successfully finished!");
    }
}
