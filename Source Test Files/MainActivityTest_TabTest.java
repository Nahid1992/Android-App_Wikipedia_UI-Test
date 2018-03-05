package org.wikipedia;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_TabTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_TabTest() {


        Clear_app_data.clear();


        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.search_container), isDisplayed()));
        linearLayout.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction searchAutoComplete;
        try {
             searchAutoComplete = onView(
                    allOf(withId(R.id.search_src_text),
                            withParent(allOf(withId(R.id.search_plate), withParent(withId(R.id.search_edit_frame))
                            )),
                            isDisplayed()));
        }catch(NoMatchingViewException e){
             searchAutoComplete = onView(
                    allOf(withId(R.id.search_src_text),
                            withParent(allOf(withId(R.id.search_plate),
                                    withParent(withId(R.id.search_edit_frame)))),
                            isDisplayed()));
        }
		SleepUtil.sleep(5);
/*
        searchAutoComplete.perform(replaceText("software"), closeSoftKeyboard());

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.page_list_item_container),
                        childAtPosition(
                                allOf(withId(R.id.search_results_list),
                                        withParent(withId(R.id.search_results_container))),
                                0),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.page_toolbar)),
                        isDisplayed()));
        imageButton.perform(click());

        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.search_container), isDisplayed()));
        linearLayout3.perform(click());

        ViewInteraction searchAutoComplete2 = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
                        */
        searchAutoComplete.perform(replaceText("google"), closeSoftKeyboard());

        ViewInteraction linearLayout4 = onView(
                allOf(withId(R.id.page_list_item_container),
                        childAtPosition(
                                allOf(withId(R.id.search_results_list),
                                        withParent(withId(R.id.search_results_container))),
                                0),
                        isDisplayed()));
        linearLayout4.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.page_toolbar)),
                        isDisplayed()));
        imageButton2.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_feed_tabs), withContentDescription("Show tabs"), isDisplayed()));
        actionMenuItemView.perform(click());
/*
        ViewInteraction textView = onView(
                allOf(withId(R.id.tab_item_title), withText("Software"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Software")));
*/
        SleepUtil.sleep(5);
		ViewInteraction textView2 = onView(
                allOf(withId(R.id.tab_item_title), withText("Google"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Google")));
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.action_mode_close_button), withContentDescription("Done"),
                        withParent(allOf(withId(R.id.action_mode_bar),
                                withParent(withId(R.id.action_bar_root)))),
                        isDisplayed()));
        appCompatImageView.perform(click());
		SleepUtil.sleep(5);
		
        Clear_app_data.clear();

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
