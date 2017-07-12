package com.anbu.switchmediaexercise;

import android.test.ApplicationTestCase;

/**
 * Created by anbu.ezhilan on 9/07/2017.
 */

@SuppressWarnings("deprecation")
public class ApplicationTest extends ApplicationTestCase<AcmeApplication> {

    public ApplicationTest() {
        super(AcmeApplication.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
        AcmeApplication application = getApplication();

    }



}