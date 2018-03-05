package org.wikipedia;


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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_SettingsImageToggle {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_SettingsImageToggle() {

        Clear_app_data.clear();

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_overflow_button), withContentDescription("More options"), isDisplayed()));
        actionMenuItemView.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.explore_overflow_settings), withText("Settings"), isDisplayed()));
        appCompatTextView.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.list),
                        withParent(withId(android.R.id.list_container)),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(2, click()));
		SleepUtil.sleep(5);
		
        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        imageButton.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.search_container), isDisplayed()));
        linearLayout.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("google"), closeSoftKeyboard());
		SleepUtil.sleep(5);
		
        ViewInteraction imageView = onView(
                allOf(withId(R.id.page_list_item_image),
                        childAtPosition(
                                allOf(withId(R.id.page_list_item_container),
                                        childAtPosition(
                                                withId(R.id.search_results_list),
                                                0)),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
		SleepUtil.sleep(5);
		
        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.page_list_item_container),
                        childAtPosition(
                                allOf(withId(R.id.search_results_list),
                                        withParent(withId(R.id.search_results_container))),
                                0),
                        isDisplayed()));
        linearLayout2.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction webView = onView(
                allOf(withId(R.id.page_web_view), isDisplayed()));
        webView.check(matches(isDisplayed()));
		SleepUtil.sleep(5);
		
        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.page_toolbar)),
                        isDisplayed()));
        imageButton2.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_overflow_button), withContentDescription("More options"), isDisplayed()));
        actionMenuItemView2.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.explore_overflow_settings), withText("Settings"), isDisplayed()));
        appCompatTextView2.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.list),
                        withParent(withId(android.R.id.list_container)),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(2, click()));
		SleepUtil.sleep(5);
		
        ViewInteraction imageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        imageButton3.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.search_container), isDisplayed()));
        linearLayout3.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction searchAutoComplete2 = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        searchAutoComplete2.perform(replaceText("google"), closeSoftKeyboard());
		SleepUtil.sleep(5);
		
        ViewInteraction linearLayout4 = onView(
                allOf(withId(R.id.page_list_item_container),
                        childAtPosition(
                                allOf(withId(R.id.search_results_list),
                                        withParent(withId(R.id.search_results_container))),
                                0),
                        isDisplayed()));
        linearLayout4.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.view_article_header_image_image), isDisplayed()));
        imageView2.check(matches(isDisplayed()));
		SleepUtil.sleep(5);
		
        ViewInteraction imageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.page_toolbar)),
                        isDisplayed()));
        imageButton4.perform(click());

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
