package org.aksw.gerbil.annotators;

import it.acubelab.batframework.problems.TopicSystem;
import it.acubelab.batframework.systemPlugins.TagmeAnnotator;

import org.aksw.gerbil.config.GerbilConfiguration;
import org.aksw.gerbil.datatypes.ExperimentType;

public class TagMeAnnotatorConfig extends AbstractAnnotatorConfiguration {
    
    public static final String ANNOTATOR_NAME = "TagMe 2";

    private static final String TAGME_CONFIG_FILE_PROPERTY_NAME = "org.aksw.gerbil.annotators.TagmeAnnotatorConfig.ConfigFile";

    public TagMeAnnotatorConfig() {
        super(ANNOTATOR_NAME, true, new ExperimentType[] { ExperimentType.Sa2W });
    }

    @Override
    protected TopicSystem loadAnnotator(ExperimentType type) throws Exception {
        return new TagmeAnnotator(GerbilConfiguration.getInstance().getString(TAGME_CONFIG_FILE_PROPERTY_NAME));
    }

    
}
