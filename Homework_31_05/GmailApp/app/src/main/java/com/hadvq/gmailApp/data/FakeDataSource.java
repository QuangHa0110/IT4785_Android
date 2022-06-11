package com.hadvq.gmailApp.data;

import com.hadvq.gmailApp.R;
import com.hadvq.gmailApp.maillist.MailItem;
import com.hadvq.gmailApp.maillist.MailSimpleItem;

import java.util.ArrayList;
import java.util.List;

public class FakeDataSource {


    // Dummy Titles

    public static final String TITLE_1 ="Edurila.com";
    public static final String TITLE_2 ="Chirs Abad";
    public static final String TITLE_3 ="Tuto.com";
    public static final String TITLE_4 ="support";
    public static final String TITLE_5 ="Matt from lonic";
    public static final String TITLE_6 ="Anna Smith";
    public static final String TITLE_7 ="Android Blog Daily Post";
    public static final String TITLE_8 ="Google Team";

    // Dummy User Images

    public static final int IMG_1 = R.drawable.pnggoogle;
    public static final int IMG_2 = R.drawable.adobe ;
    public static final int IMG_3 = R.drawable.user4;
    public static final int IMG_4 = R.drawable.user;
    public static final int IMG_5 = R.drawable.user2;
    public static final int IMG_6 = R.drawable.girl0;
    public static final int IMG_7 = R.drawable.androidstudio;


    // Dummy Mail Content
    public static final String Content_1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    // Dummy Description
    public static final String DESC_1 = "Lorem ipsum dolor sit amet";
    public static final String DESC_2 = "Lorem ipsum dolor sit amet";
    public static final String DESC_3 = "Lorem ipsum dolor sit amet";
    public static final String DESC_4 = "Lorem ipsum dolor sit amet";
    public static final String DESC_5 = "Lorem ipsum dolor sit amet";
    public static final String DESC_6 = "Lorem ipsum dolor sit amet";
    public static final String DESC_7 = "Lorem ipsum dolor sit amet";






    public static List<MailItem> getListMail(){

        List<MailItem> data = new ArrayList<>();






        data.add(new MailItem(new MailSimpleItem(
                1,
                TITLE_1,
                DESC_1,
                R.drawable.e,
                Content_1,
                true
        )));

        data.add(new MailItem(new MailSimpleItem(
                2,
                TITLE_2,
                DESC_1,
                R.drawable.c,
                Content_1
        )));

        data.add(new MailItem(new MailSimpleItem(
                3,
                TITLE_3,
                DESC_1,
                R.drawable.t,
                Content_1,
                true,
                true
        )));
        data.add(new MailItem(new MailSimpleItem(
                4,
                TITLE_4,
                DESC_1,
                R.drawable.s,
                Content_1
        )));
        data.add(new MailItem(new MailSimpleItem(
                5,
                TITLE_5,
                DESC_1,
                R.drawable.m,
                Content_1

        )));
        data.add(new MailItem(new MailSimpleItem(
                6,
                TITLE_6,
                DESC_1,
                R.drawable.a,
                Content_1
        )));




        return data;
    }


}
