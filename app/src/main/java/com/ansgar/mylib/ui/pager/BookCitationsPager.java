package com.ansgar.mylib.ui.pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ansgar.mylib.R;
import com.ansgar.mylib.database.entity.Author;
import com.ansgar.mylib.database.entity.Book;
import com.ansgar.mylib.ui.base.BaseFragment;
import com.ansgar.mylib.ui.base.BasePresenter;
import com.ansgar.mylib.ui.fragments.BookCitationsFragment;
import com.ansgar.mylib.ui.fragments.AuthorDetailsFragment;
import com.ansgar.mylib.ui.fragments.BookDetailsFragment;
import com.ansgar.mylib.ui.presenter.fragment.BookCitationsPagerPresenter;
import com.ansgar.mylib.ui.view.fragment.BookCitationsPagerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kirill on 30.1.17.
 */

public class BookCitationsPager extends BaseFragment implements BookCitationsPagerView {

    private static final int LAYOUT = R.layout.pager_book_citations;
    private static final String EXTRA_BOOK = "com.ansgar.mylib.ui.pager.book";

    private BookCitationsPagerPresenter mPresenter;
    private Book mBook;

    @BindView(R.id.author_books_pager)
    ViewPager mAuthorBooksPager;

    public static BookCitationsPager newInstance(Book book) {
        BookCitationsPager pager = new BookCitationsPager();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_BOOK, book);
        pager.setArguments(args);
        return pager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        mBook = (Book) getArguments().getSerializable(EXTRA_BOOK);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuthorBooksPager.setAdapter(getAdapter());
    }

    private FragmentStatePagerAdapter getAdapter() {
        return new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) return BookDetailsFragment.newInstance(mBook);
                if (position == 1) return BookCitationsFragment.newInstance(mBook);
                return null;
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new BookCitationsPagerPresenter(this);
    }
}
