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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_Language {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_Language() {
        Clear_app_data.clear();


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

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.page_list_item_container),
                        childAtPosition(
                                allOf(withId(R.id.search_results_list),
                                        withParent(withId(R.id.search_results_container))),
                                0),
                        isDisplayed()));
        linearLayout2.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView = onView(
                allOf(withText("b#3"), isDisplayed()));
        appCompatTextView.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction plainPasteEditText = onView(
                allOf(withId(R.id.langlinks_filter), isDisplayed()));
        plainPasteEditText.perform(replaceText("afrikaans"), closeSoftKeyboard());
        SleepUtil.sleep(5);

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.langlinks_list),
                                withParent(withId(R.id.langlinks_list_container))),
                        0),
                        isDisplayed()));
        linearLayout3.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView2 = onView(
                allOf(withText("b#5"), isDisplayed()));
        appCompatTextView2.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction textView = onView(
                allOf(withId(R.id.page_toc_item_text), withText("Die naam Google"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.page_toc_list),
                                        1),
                                1),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
        SleepUtil.sleep(5);

        pressBack();
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView3 = onView(
                allOf(withText("b#3"), isDisplayed()));
        appCompatTextView3.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction plainPasteEditText2 = onView(
                allOf(withId(R.id.langlinks_filter), isDisplayed()));
        plainPasteEditText2.perform(replaceText("english"), closeSoftKeyboard());
        SleepUtil.sleep(5);

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.langlinks_list),
                                withParent(withId(R.id.langlinks_list_container))),
                        0),
                        isDisplayed()));
        linearLayout4.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView4 = onView(
                allOf(withText("b#5"), isDisplayed()));
        appCompatTextView4.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.page_toc_item_text), withText("History"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.page_toc_list),
                                        1),
                                1),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));
        SleepUtil.sleep(5);

        pressBack();
        SleepUtil.sleep(5);

        pressBack();

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
