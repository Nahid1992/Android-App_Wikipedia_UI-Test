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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_SignIn {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_SignIn() {

        Clear_app_data.clear();

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_overflow_button), withContentDescription("More options"), isDisplayed()));
        actionMenuItemView.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.explore_overflow_account_container), isDisplayed()));
        linearLayout.perform(click());
        SleepUtil.sleep(5);

        ViewInteraction plainPasteEditText = onView(
                withId(R.id.login_username_text));
        plainPasteEditText.perform(scrollTo(), click());
        SleepUtil.sleep(5);

        ViewInteraction plainPasteEditText2 = onView(
                withId(R.id.login_username_text));
        plainPasteEditText2.perform(scrollTo(), replaceText("abc"), closeSoftKeyboard());
        SleepUtil.sleep(5);

        ViewInteraction plainPasteEditText3 = onView(
                allOf(withId(R.id.password_edit_text_input), isDisplayed()));
        plainPasteEditText3.perform(replaceText("abc123"), closeSoftKeyboard());
        SleepUtil.sleep(5);

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.login_button), withText("Log in")));
        appCompatButton.perform(scrollTo(), click());
        SleepUtil.sleep(5);

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0),
                        isDisplayed()));
        linearLayout2.check(matches(isDisplayed()));
        SleepUtil.sleep(5);

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.login_create_account_link), withText("Don't have an account? Join Wikipedia")));
        appCompatTextView.perform(scrollTo(), click());
        SleepUtil.sleep(5);

        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.create_account_primary_container),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        linearLayout3.check(matches(isDisplayed()));
        SleepUtil.sleep(5);

        pressBack();
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
