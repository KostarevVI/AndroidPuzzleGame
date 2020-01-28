package com.example.androidpuzzlegame;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.grid),
                        childAtPosition(
                                withId(R.id.layoutConstraint),
                                0)))
                .atPosition(0);
        constraintLayout.perform(click());

        DataInteraction constraintLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.grid),
                        childAtPosition(
                                withId(R.id.layoutConstraint),
                                0)))
                .atPosition(0);
        constraintLayout2.perform(click());

        DataInteraction constraintLayout3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.grid),
                        childAtPosition(
                                withId(R.id.layoutConstraint),
                                0)))
                .atPosition(1);
        constraintLayout3.perform(click());

        DataInteraction constraintLayout4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.grid),
                        childAtPosition(
                                withId(R.id.layoutConstraint),
                                0)))
                .atPosition(2);
        constraintLayout4.perform(click());

        DataInteraction constraintLayout5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.grid),
                        childAtPosition(
                                withId(R.id.layoutConstraint),
                                0)))
                .atPosition(3);
        constraintLayout5.perform(click());

        DataInteraction constraintLayout6 = onData(anything())
                .inAdapterView(allOf(withId(R.id.grid),
                        childAtPosition(
                                withId(R.id.layoutConstraint),
                                0)))
                .atPosition(4);
        constraintLayout6.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.gridImageview),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.grid),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(doesNotExist());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
