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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_History {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_History() {

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

        searchAutoComplete.perform(replaceText("google"), closeSoftKeyboard());
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

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.page_toolbar)),
                        isDisplayed()));
        imageButton2.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView = onView(
                //allOf(withClassName(is("android.support.v7.widget.AppCompatTextView")), isDisplayed()));
                allOf(withText("History"), isDisplayed()));
        appCompatTextView.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction textView = onView(
                allOf(withId(R.id.page_list_item_title), withText("Google"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Google")));
        SleepUtil.sleep(5);

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_clear_all_history), withContentDescription("Clear history"), isDisplayed()));
        actionMenuItemView.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction appCompatButton = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction linearLayout11 = onView(
                allOf(withId(R.id.history_empty_container),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_main_view_pager),
                                        1),
                                0),
                        isDisplayed()));
        linearLayout11.check(matches(isDisplayed()));
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView2 = onView(
                allOf(withText("Explore"), isDisplayed()));
        appCompatTextView2.perform(click());

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
