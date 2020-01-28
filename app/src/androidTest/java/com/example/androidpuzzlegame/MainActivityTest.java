package com.example.androidpuzzlegame;

import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        //1
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(0).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //2
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(1).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //3
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(2).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //4
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(3).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //5
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(4).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //6
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(5).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //7
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(6).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //8
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(7).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //9
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(8).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
        //10
        onData(anything()).inAdapterView(allOf(withId(R.id.grid), childAtPosition(withId(
                R.id.layoutConstraint), 0))).atPosition(9).perform(click()).check(doesNotExist());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(allOf(withId(R.id.grid))).check(matches(isDisplayed()));
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
