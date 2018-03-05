package org.wikipedia;


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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_ManagingReadingList {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_ManagingReadingList() {

        Clear_app_data.clear();

        ViewInteraction linearLayout = onView(
                //allOf(withId(R.id.search_container), isDisplayed()));
                allOf(withId(R.id.search_container), isDisplayed()));
        linearLayout.perform(click());
		SleepUtil.sleep(5);
/*		
        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),
                                withParent(withId(R.id.search_edit_frame)))),
                        isDisplayed()));
        */

        ViewInteraction searchAutoComplete = onView(
                allOf(withId(R.id.search_src_text),
                        withParent(allOf(withId(R.id.search_plate),withParent(withId(R.id.search_edit_frame))
                                )),
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
                allOf(withText("b#1"), isDisplayed()));
        appCompatTextView.perform(click());
		SleepUtil.sleep(5);
		
        try {
            ViewInteraction appCompatButton = onView(
                    allOf(withId(R.id.onboarding_button), withText("Got it"),
                            withParent(withId(R.id.onboarding_container)),
                            isDisplayed()));
            appCompatButton.perform(click());
            //SleepUtil.sleep(5);
        }catch(NoMatchingViewException e) {
            ViewInteraction linearLayout99 = onView(
                    allOf(withId(R.id.create_button),
                            withParent(withId(R.id.lists_container)),
                            isDisplayed()));
            linearLayout99.perform(click());
            //SleepUtil.sleep(5);
        }
		SleepUtil.sleep(5);
		
        ViewInteraction plainPasteEditText = onView(
                allOf(withId(R.id.reading_list_title)));
        plainPasteEditText.perform(scrollTo(), replaceText("Google"), closeSoftKeyboard());
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton2.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.page_toolbar)),
                        isDisplayed()));
        imageButton.perform(click());
		SleepUtil.sleep(5);

        ViewInteraction appCompatTextView3 = onView(
                allOf(withText("My lists"), isDisplayed()));
        appCompatTextView3.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction textView = onView(
                allOf(withId(R.id.item_title), withText("Google"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.item_container),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Google")));
        SleepUtil.sleep(5);



        
        ViewInteraction linearLayout6 = onView(
                allOf(withId(R.id.item_container), isDisplayed()));
        linearLayout6.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.button_edit), withContentDescription("Edit reading list details"), isDisplayed()));
                //allOf(withText("Edit reading list details"), isDisplayed()));
        floatingActionButton.perform(click());
        SleepUtil.sleep(5);

        /*
        ViewInteraction plainPasteEditText3 = onView(
                allOf(withId(R.id.reading_list_title), withText("Google")));
        plainPasteEditText3.perform(scrollTo(), click());
        */
        ViewInteraction plainPasteEditText4 = onView(
                allOf(withId(R.id.reading_list_title), withText("Google")));
        //plainPasteEditText4.perform(scrollTo(), replaceText("Google123"), closeSoftKeyboard());
        plainPasteEditText4.perform(scrollTo(), replaceText("Google123"));
		SleepUtil.sleep(5);

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton4.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.reading_list_detail_back_button),
                        withParent(allOf(withId(R.id.details_container),
                                withParent(withId(R.id.contents_container)))),
                        isDisplayed()));
        appCompatImageView.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction textView3 = onView(
                allOf(withId(R.id.item_title), withText("Google123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.item_container),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Google123")));
		SleepUtil.sleep(5);
		
        ViewInteraction linearLayout7 = onView(
                allOf(withId(R.id.item_container), isDisplayed()));
        linearLayout7.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.button_edit), withContentDescription("Edit reading list details"), isDisplayed()));
        floatingActionButton2.perform(click());
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.reading_list_delete_link), withText("Delete reading list")));
        appCompatTextView4.perform(scrollTo(), click());
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatButton5 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton5.perform(click());
		SleepUtil.sleep(5);

        ViewInteraction textView101 = onView(
                allOf(withId(R.id.empty_title),isDisplayed()));
        textView101.check(matches(withText("No reading lists here.")));
		SleepUtil.sleep(5);
		
        ViewInteraction appCompatTextView6 = onView(
                allOf(withText("Explore"), isDisplayed()));
        appCompatTextView6.perform(click());

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
