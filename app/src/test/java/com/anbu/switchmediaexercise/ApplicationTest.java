package com.anbu.switchmediaexercise;

import android.test.ApplicationTestCase;

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