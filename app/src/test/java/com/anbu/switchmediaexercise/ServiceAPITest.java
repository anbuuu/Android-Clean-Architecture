package com.anbu.switchmediaexercise;

import com.anbu.switchmediaexercise.data.net.AcmeService;
import com.anbu.switchmediaexercise.data.net.AcmeServiceImpl;
import com.anbu.switchmediaexercise.domain.model.CategoryList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Collections;

import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Tests for connectivity and Category List Results
 */

@RunWith(MockitoJUnitRunner.class)
public class ServiceAPITest {

    @Mock
    AcmeService acmeService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUsingTestSubscriber() throws Exception {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        Observable.just(1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Collections.singletonList(1));
    }

    @Test
    public void fetchValidData() {
        TestSubscriber<ArrayList<CategoryList>> testSubscriber =
                TestSubscriber.create();
        AcmeServiceImpl.getInstance().getMediaListData().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

    }
}
