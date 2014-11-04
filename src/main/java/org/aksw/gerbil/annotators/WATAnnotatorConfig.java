package org.aksw.gerbil.annotators;

import it.acubelab.batframework.problems.TopicSystem;

import org.aksw.gerbil.bat.annotator.WATAnnotator;
import org.aksw.gerbil.config.GerbilConfiguration;
import org.aksw.gerbil.datatypes.ExperimentType;

public class WATAnnotatorConfig extends AbstractAnnotatorConfiguration {
    public static final String ANNOTATOR_NAME = "WAT";
    private static final String WAT_CONFIG_FILE_PROPERTY_ENDPOINT = "org.aksw.gerbil.annotators.wat.endpoint";
    private static final String WAT_CONFIG_FILE_PROPERTY_PARAMETERS = "org.aksw.gerbil.annotators.wat.parameters";

    public WATAnnotatorConfig() {
        super(ANNOTATOR_NAME, true, new ExperimentType[] { ExperimentType.Sa2W});
    }

    @Override
    protected TopicSystem loadAnnotator(ExperimentType type) throws Exception {
        String endpoint = GerbilConfiguration.getInstance().getString(WAT_CONFIG_FILE_PROPERTY_ENDPOINT);
        String urlParameters = GerbilConfiguration.getInstance().getString(WAT_CONFIG_FILE_PROPERTY_PARAMETERS);

        if (endpoint == null)
            return null;

        if (urlParameters == null)
            return new WATAnnotator(endpoint, "");
        else
            return new WATAnnotator(endpoint, urlParameters);
    }
}
