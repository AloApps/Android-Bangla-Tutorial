Table of Contents

Get name of current method

Get string length

Convert String to Int and vice-versa

Check if device has internet

Setup a countdown timer

Convert String to Date in Java

Convert Java util.Date to sql.Date

Creating JSON data

Create a simple alert dialog with 2 buttons

Use animations

Make activity fullscreen

Store the number of times the app was launched

Start a browser activity

Download a file in java (async)

Capture screen shots in Java

For audio apps, make the volume buttons of the phone modify audio level for music and not for phone ringtone

Use autocomplete edit text instead of simple edit text

Display cached images if you load them from internet

Check if an app is installed (by package name)

Get Phone Number of the user

Get User Email address

Create a md5 hash

Get Device ID

Write file to SD Card

Directory listing

Read a file from RAW directory

Read a file from assets

Get Total memoy

Get Free memory

Get Used Memory

Set the entire font for the activity

Start an email intent

Show a notification on status bar

Set a ringtone/alarm or notification sound

Start the ads activity with a random number :)

Play a radio from internet (or a stream)

Share something

A Very usefull library

Send a SMS

Get Battery Level

Autostart app on boot

Setting toast to appear on some parts

Get phone last known location using Location Manager

GPS Location with listener

Using Google Voice

Parsing / Reading XML file

Press once again to exit

Send Email

Ask users to rate your app



Get name of current method

                

String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
       



Get string length

                

String s1 = "This book is awesome!!!";
int strLength  = s1.length();
System.out.println("The lengt of the string : "+strLength);
                

                
                
                    


                

                
            
       


Convert String to Int and vice-versa

                

String a = String.valueOf(2);   //integer to numeric string
        

int i = Integer.parseInt(a); //numeric string to an int
                       


Check if device has internet

                

        public static boolean isOnline(Context ctx) {
                

                ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(DUtils.CONNECTIVITY_SERVICE);
            
        

                NetworkInfo netInfo = cm.getActiveNetworkInfo();
        

                if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            
        

                        return true;
        

                }
            
        

                return false;
        

        }
               



Setup a countdown timer

                

mTimer = new MyTimmer(200, 200);
        

mTimer.start();
                        

    public class MyTimmer extends CountDownTimer {
            
                

        public MyTimmer(long millisInFuture, long countDownInterval) {
        

            super(millisInFuture, countDownInterval);
            
        

          }
                        

        public void onFinish() {
        

            launchApp();
            
                

        }
                        

        public void onTick(long millisUntilFinished) {
        

       
        

        }
        

    }
                       


Convert String to Date in Java

       


SimpleDateFormat format = new SimpleDateFormat( "dd.MM.yyyy" );

Date date = format.parse( myString );


Convert Java util.Date to sql.Date

       


java.util.Date utilDate = new java.util.Date();

java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

Creating JSON data

                

JSONObject json = new JSONObject();
        

json.put("city", "New York");
        

json.put("population", "123123213");
            
        

...
        

String output = json.toString();
               



Create a simple alert dialog with 2 buttons

                

 AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                

                try {
        

                    String[] aux = source.split(" ### ");
        

                    the_message = aux[0];
            
        

                    the_link = aux[1];
                

                    builder.setMessage(the_message)
            
        

                            .setCancelable(false)
        

                            .setNegativeButton("go to url", new DialogInterface.OnClickListener() {
            
        

                                @Override
        

                                public void onClick(DialogInterface dialogInterface, int i) {
            
        

                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(the_link));
        

                                    startActivity(browserIntent);
                

                                }
            
        

                            })
        

                            .setPositiveButton("cancel", new DialogInterface.OnClickListener() {
            
        

                                public void onClick(DialogInterface dialog, int id) {
        

                                    dialog.dismiss();
            
        

                                    mTimer = new MyTimmer(200, 200);
        

                                    mTimer.start();
            
        

                                }
        

                            });
            
                

                } catch (Exception ex) {
        

                    builder.setMessage(source)
            
        

                            .setCancelable(false)
        

                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            
        

                                public void onClick(DialogInterface dialog, int id) {
        

                                    dialog.dismiss();
            
        

                                    mTimer = new MyTimmer(200, 200);
        

                                    mTimer.start();
            
        

                                }
        

                            });
            
        

                }
                        

                AlertDialog alert = builder.create();
            
        

                alert.show();
                       


Use animations

                

Animation slide_left = AnimationUtils.loadAnimation(this, R.anim.wave_scale);
        

Animation slide_right = AnimationUtils.loadAnimation(this, R.anim.wave_scale);
            
        

textView_splash_title.startAnimation(slide_left);
        

textView_splash_subtitle.startAnimation(slide_right);
               



Make activity fullscreen

                

requestWindowFeature(Window.FEATURE_NO_TITLE);
        

getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        

WindowManager.LayoutParams.FLAG_FULLSCREEN);
                       


Store the number of times the app was launched

                        

  SharedPreferences prefs1 = mContext.getSharedPreferences("PREFS", 0);
        

   launched_times = prefs1.getInt("launched_times",0);
            
        

   Log.i("______launched times________", String.valueOf(launched_times));
        

   SharedPreferences.Editor editor = prefs1.edit();
        

   editor.putInt("launched_times",launched_times+1);
        

   editor.commit();
               



Start a browser activity

                

 Intent browserIntent = new Intent(Intent.ACTION_VIEW,                                         Uri.parse("https://play.google.com/store/apps/details?id=com.bobysan.freemusicdownload"));
            
        

startActivity(browserIntent);
                       


Download a file in java (async)

                

  private class DownloadSong extends AsyncTask<String, Integer, Boolean> {
                

        private String source;
            
        

        private String download_mp3_link = "";
        

        private String song_title = "";
                        

        protected Boolean doInBackground(String... params) {
                

            String DownloadUrl = params[0];
        

            String fileName = params[1];
                

            try {
        

                File root = android.os.Environment.getExternalStorageDirectory();
            
                

                File dir = new File(root.getAbsolutePath() + "/MusicFree");
        

                if (dir.exists() == false) {
            
        

                    dir.mkdirs();
        

                }
                

                URL url = new URL(DownloadUrl); // you can write here any link
        

                File file = new File(dir, fileName);
            
                                

                song_title = fileName;
                

                long startTime = System.currentTimeMillis();
            
        

                Log.d("DownloadManager", "download begining");
        

                Log.d("DownloadManager", "download url:" + url);
            
        

                Log.d("DownloadManager", "downloaded file name:" + fileName);
                

                                /* Open a connection to that URL. */
            
        

                URLConnection ucon = url.openConnection();
                

                                /*
            
        

                 * Define InputStreams to read from the URLConnection.
        

                                 */
            
        

                InputStream input = ucon.getInputStream();
        

                int fileLength = ucon.getContentLength();
            
        

                OutputStream output = new FileOutputStream(root.getAbsolutePath() + "/MusicFree/" + fileName + ".mp3");
                

                download_mp3_link = (root.getAbsolutePath() + "/MusicFree/" + fileName + ".mp3");
                

                byte data[] = new byte[1024];
            
        

                long total = 0;
        

                int count;
        

                while ((count = input.read(data)) != -1) {
        

                    total += count;
        

                    // publishing the progress....
        

                    publishProgress((int) (total * 100 / fileLength));
            
        

                    output.write(data, 0, count);
        

                }
                

                output.flush();
        

                output.close();
        

                input.close();
                

                return true;
        

            } catch (IOException e) {
            
        

                Log.d("DownloadManager", "Error: " + e);
        

                return false;
            
        

            }
                

        }
                

        @Override
        

        protected void onProgressUpdate(Integer... values) {
        

            // TODO Auto-generated method stub
            
        

            super.onProgressUpdate(values);
                

            mProgressDialog.setProgress(values[0]);
                

                        /*
        

             contentText =  String.valueOf(values[0]) + "% complete";
            
        

                 notification.setLatestEventInfo(getApplicationContext(), contentTitle, contentText, contentIntent);
        

                 notificationManager.notify(HELLO_ID, notification);
        

                 */
            
                        

        }
                

        protected void onPreExecute() {
        

            super.onPreExecute();
            
                

            mProgressDialog.show();
                

            // ------ taskbar notification ---------
        

            /*
        

            String ns = Context.NOTIFICATION_SERVICE;
        

                        notificationManager = (NotificationManager) getSystemService(ns);
            
        

                        icon = R.drawable.ic_launcher;
        

                        tickerText = "Downloading...";
            
        

                        time = System.currentTimeMillis();
        

            notification = new Notification(icon, tickerText, time);
        

            contentTitle = "MusicFree download in progress";
        

            contentText = "0% complete";
        

            Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
        

            notificationIntent.setDataAndType(Uri.fromFile(new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/MusicFree/"+song_name+".mp3")), "audio/*");
            
        

            contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);
        

            notification.setLatestEventInfo(getApplicationContext(), contentTitle, contentText, contentIntent);
            
        

            notificationManager.notify(HELLO_ID, notification);
        

                        */
            
        

        }
                

        protected void onPostExecute(Boolean result) {
                

            super.onPostExecute(result);
            
                

            if (result) {
        

                Toast.makeText(mContext, "file downloaded to SDcard/MusicFree", Toast.LENGTH_LONG).show();
            
                                                

            }
                

            try {
        


                                mProgressDialog.dismiss();
        

            } catch (Exception e) {
        

                Log.e("EXCEPTION", "!!!!");
            
        

            }
                

        }
                

    }
               



Capture screen shots in Java

       


   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

   Rectangle screenRectangle = new Rectangle(screenSize);

   Robot robot = new Robot();

   BufferedImage image = robot.createScreenCapture(screenRectangle);

   ImageIO.write(image, "png", new File(fileName));

For audio apps, make the volume buttons of the phone modify audio level for music and not for phone ringtone

                

mContext = MainActivity.this;
        

mContext.setVolumeControlStream(AudioManager.STREAM_MUSIC);
               



Use autocomplete edit text instead of simple edit text

                

String STYLES[] = {"Alternative Rock", "Ambient", "Blues", "Classical", "Country", "Dance", "Deep House", "Disco", "Drum & Bass"};
            
                

 ArrayAdapter<String> ac_adapter = new ArrayAdapter<String>(mContext,
        

                android.R.layout.simple_dropdown_item_1line, STYLES);
            
                

 AutoCompleteTextView editText_main_search = (AutoCompleteTextView) findViewById(R.id.editText_main_search);
        

editText_main_search.setAdapter(ac_adapter);
            
        

editText_main_search.setThreshold(1);
                       


Display cached images if you load them from internet

                

see https://github.com/nostra13/Android-Universal-Image-Loader
                

        DisplayImageOptions options = new DisplayImageOptions.Builder()
            
        

                .showImageOnLoading(R.drawable.music_icon) // resource or drawable
        

                .showImageForEmptyUri(R.drawable.music_icon) // resource or drawable
            
        

                .showImageOnFail(R.drawable.music_icon) // resource or drawable
        

                .build();
            
                

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
        

                .threadPriority(Thread.NORM_PRIORITY - 2)
            
        

                .denyCacheImageMultipleSizesInMemory()
        

                .discCacheFileNameGenerator(new Md5FileNameGenerator())
            
        

                .tasksProcessingOrder(QueueProcessingType.LIFO)
        

                .build();
            
                

        ImageLoader.getInstance().init(config);
                        

        imageLoader = ImageLoader.getInstance();
                       



Check if an app is installed (by package name)

                

public static boolean isAppInstalled(Context ctx,String uri) {
        

                PackageManager pm = ctx.getPackageManager();
            
        

                boolean installed = false;
        

                try {
            
        

                        pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
        

                        installed = true;
        

                } catch (PackageManager.NameNotFoundException e) {
            
        

                        installed = false;
        

                }
            
        

                return installed;
        

        }
                       


Get Phone Number of the user

                

        public static String getMyPhoneNumber(Context ctx) {
                

                try {
            
        

                        TelephonyManager mTelephonyMgr;
        

                        mTelephonyMgr = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            
        

                        return mTelephonyMgr.getLine1Number();
        

                } catch (Exception e) {
        

                        return "";
            
        

                }
                

        }
                

        public static String getMy10DigitPhoneNumber(Context ctx) {
        

                try {
            
        

                        String s = getMyPhoneNumber(ctx);
        

                        return s.substring(2);
        

                } catch (Exception e) {
            
        

                        return "";
        

                }
            
                

        }
               



Get User Email address

                        

        public static class UserEmailFetcher {
                

                public static String getEmail(Context context) {
            
        

                        AccountManager accountManager = AccountManager.get(context);
        

                        Account account = getAccount(accountManager);
                

                        if (account == null) {
        

                                return null;
            
        

                        } else {
        

                                return account.name;
            
        

                        }
        

                }
            
                

                private static Account getAccount(AccountManager accountManager) {
        

                        Account[] accounts = accountManager.getAccountsByType("com.google");
            
        

                        Account account;
        

                        if (accounts.length > 0) {
            
        

                                account = accounts[0];
        

                        } else {
        

                                account = null;
            
        

                        }
        

                        return account;
            
        

                }
        

        }
                       


Create a md5 hash

                                

        public static final String md5(final String s) {
        

                try {
            
        

                        // Create MD5 Hash
        

                        MessageDigest digest = MessageDigest.getInstance("MD5");
            
        

                        digest.update(s.getBytes());
        

                        byte messageDigest[] = digest.digest();
            
                

                        // Create Hex String
        

                        StringBuffer hexString = new StringBuffer();
            
        

                        for (int i = 0; i < messageDigest.length; i++) {
        

                                String h = Integer.toHexString(0xFF & messageDigest[i]);
            
        

                                while (h.length() < 2)
            
        

                                        h = "0" + h;
            
        

                                hexString.append(h);
        

                        }
        

                        return hexString.toString();
            
                

                } catch (NoSuchAlgorithmException e) {
        

                        e.printStackTrace();
            
        

                }
        

                return "";
            
        

        }
               



Get Device ID

                

        public static String get_device_id(Context ctx) {
                

                final TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            
                

                final String tmDevice, tmSerial, tmPhone, androidId;
                

                try {
            
        

                        tmDevice = "" + tm.getDeviceId();
        

                        tmSerial = "" + tm.getSimSerialNumber();
        

                        androidId = "" + android.provider.Settings.Secure.getString(ctx.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            
        

                        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
            
        

                        String deviceId = deviceUuid.toString();
                


                                        return deviceId;
        

                } catch (Exception ex) {
            
        

                        return "nodeviceid";
        

                }
            
        

        }
                       



Write file to SD Card

                

        public static Boolean writeToSDFile(String directory, String file_name, String text) {
                

                // Find the root of the external storage.
            
        

                // See
        

                // http://developer.android.com/guide/topics/data/data-storage.html#filesExternal
            
                

                File root = Environment.getExternalStorageDirectory();
                

                // See
            
        

                // http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder
                

                File dir = new File(root.getAbsolutePath() + "/" + directory);
        

                dir.mkdirs();
            
        

                File file = new File(dir, file_name);
                

                try {
            
        

                        FileOutputStream f = new FileOutputStream(file);
        


                                        PrintWriter pw = new PrintWriter(f);
        

                        pw.println(text);
            
        

                        pw.flush();
        

                        pw.close();
            
        

                        f.close();
        

                        // Log.v(TAG, "file written to sd card");
            
        

                        return true;
        

                } catch (FileNotFoundException e) {
            
        

                        e.printStackTrace();
        

                        // Log.i(TAG, "******* File not found. Did you" +
            
        

                        // " add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
            
        

                        return false;
        

                } catch (IOException e) {
            
        

                        e.printStackTrace();
        

                        return false;
            
        

                }
                

        }
               



Directory listing



        
                
        

            
            
                

File dir = new File("directoryName");


                    

  String[] children = dir.list();


                    

  if (children == null) {


                    

      // Either dir does not exist or is not a directory


                    

  } else {


                    

      for (int i=0; i < children.length; i++) {


                    

          // Get filename of file or directory


                    

          String filename = children[i];


                    

      }


                    

  }


                    

 


                    

  // It is also possible to filter the list of returned files.


                    

  // This example does not return any files that start with `.'.


                    

  FilenameFilter filter = new FilenameFilter() {


                    

      public boolean accept(File dir, String name) {


                    

          return !name.startsWith(".");


                    

      }


                    

  };


                    

  children = dir.list(filter);


                    

 


                    

  // The list of files can also be retrieved as File objects


                    

  File[] files = dir.listFiles();


                    

 


                    

  // This filter only returns directories


                    

  FileFilter fileFilter = new FileFilter() {


                    

      public boolean accept(File file) {


                    

          return file.isDirectory();


                    

      }


                    

  };


                    

  files = dir.listFiles(fileFilter);

            

            
        

        


Read a file from RAW directory

                

        /**
        

         * Method to read in a text file placed in the res/raw directory of the
            
        

         * application. The method reads in all lines of the file sequentially.
        

         */
            
                

        public static void readRaw(Context ctx, int res_id) {
                

                InputStream is = ctx.getResources().openRawResource(res_id);
            
        

                InputStreamReader isr = new InputStreamReader(is);
        

                BufferedReader br = new BufferedReader(isr, 8192); // 2nd arg is buffer
            
        

                                                                                                                        // size
            
                

                // More efficient (less readable) implementation of above is the
        

                // composite expression
            
        

                /*
        

                 * BufferedReader br = new BufferedReader(new InputStreamReader(
            
        

                 * this.getResources().openRawResource(R.raw.textfile)), 8192);
        

                 */
            
                

                try {
        

                        String test;
            
        

                        while (true) {
        

                                test = br.readLine();
            
        

                                // readLine() returns null if no more lines in the file
            
        

                                if (test == null)
        

                                        break;
            
        

                        }
        

                        isr.close();
            
        

                        is.close();
        

                        br.close();
            
        

                } catch (IOException e) {
        

                        e.printStackTrace();
            
        

                }
                

        }
               



Read a file from assets

                

        public static String getQuestions(Context ctx, String file_name) {
                

                AssetManager assetManager = ctx.getAssets();
            
        

                ByteArrayOutputStream outputStream = null;
        

                InputStream inputStream = null;
            
        

                try {
        

                        inputStream = assetManager.open(file_name);
            
        

                        outputStream = new ByteArrayOutputStream();
        

                        byte buf[] = new byte[1024];
        

                        int len;
            
        

                        try {
        

                                while ((len = inputStream.read(buf)) != -1) {
            
        

                                        outputStream.write(buf, 0, len);
            
        

                                }
        

                                outputStream.close();
        

                                inputStream.close();
        

                        } catch (IOException e) {
        

                        }
            
        

                } catch (IOException e) {
        

                }
            
        

                return outputStream.toString();
                

        }
            
                               



Get Total memoy

                

        public static int TotalMemory() {
        

                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            
        

                int Total = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
        

                return Total;
            
        

        }
                       


Get Free memory

                

        public static int FreeMemory() {
        

                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            
        

                int Free = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
        

                return Free;
            
        

        }
               



Get Used Memory

                

        public static int BusyMemory() {
        

                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            
        

                int Total = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
        

                int Free = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
            
        

                int Busy = Total - Free;
        

                return Busy;
            
        

        }
                       


Set the entire font for the activity

                

/*****************************************************************************************
        

         * SETS THE ENTIRE FONT FOR THE ACTIVITY!
            
        

         * 
        

         * mContext = AddSpellActivity.this;
        

         * 
        

         * Typeface tf1 = Typeface.createFromAsset(mContext.getAssets(),
        

         * "fonts/KaushanScript-Regular.otf"); final ViewGroup mContainer =
        

         * (ViewGroup) findViewById(android.R.id.content).getRootView();
            
        

         * setAppFont(mContainer, tf2);
        

         * 
        


                         * 
        

         * @param mContainer
        

         * @param mFont
            
        

         */
                

        public static final void setAppFont(ViewGroup mContainer, Typeface mFont) {
            
        

                if (mContainer == null || mFont == null)
        

                        return;
            
                

                final int mCount = mContainer.getChildCount();
                

                // Loop through all of the children.
            
        

                for (int i = 0; i < mCount; ++i) {
        

                        final View mChild = mContainer.getChildAt(i);
            
        

                        if (mChild instanceof TextView) {
        

                                // Set the font if it is a TextView.
        

                                ((TextView) mChild).setTypeface(mFont);
        

                        } else if (mChild instanceof ViewGroup) {
        

                                // Recursively attempt another ViewGroup.
            
        

                                setAppFont((ViewGroup) mChild, mFont);
            
        

                        }
        

                }
            
        

        }
               



Start an email intent

                

                                Toast.makeText(InfoActivity.this, "thank you for the feedback", Toast.LENGTH_LONG).show();
            
        

                                Intent intent = new Intent(Intent.ACTION_SEND);
            
        

                                intent.setType("plain/text");
            
        

                                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "android@ofertaweb.ro" });
            
        

                                intent.putExtra(Intent.EXTRA_SUBJECT, "Free Music Download bobysan Feedback");
            
        

                                startActivity(intent);
                       


Show a notification on status bar

                

 String ns = Context.NOTIFICATION_SERVICE;
        

                NotificationManager mNotificationManager = (NotificationManager)
            
        

                        getSystemService(ns);
                

                int icon = R.drawable.ic_launcher;
            
        

                CharSequence showText = "Playing " + song_name;
        

                long time = System.currentTimeMillis();
            
        

                Notification notification = new Notification(icon, showText, time);
                        

                CharSequence contentTitle = "Free Music";
            
        

                CharSequence contentText = "Playing " + song_name;
        

                Intent notifIntent = new Intent(mContext, LibraryActivity.class);
            
        

                notification.flags = Notification.FLAG_ONGOING_EVENT;
        

                notification.flags |= Notification.FLAG_NO_CLEAR;
            
        

                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                

                notifIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
            
        

                        Intent.FLAG_ACTIVITY_SINGLE_TOP);
        

                PendingIntent contentIntent = PendingIntent.getActivity(mContext, 0,
            
        

                        notifIntent,
        

                        PendingIntent.FLAG_CANCEL_CURRENT);
            
        

                notification.setLatestEventInfo(mContext, contentTitle, contentText,
        

                        contentIntent);
            
        

                mNotificationManager.notify(1337, notification);
        

--------------------
                

    public void clearNotification() {
                

        try {
        

            NotificationManager notificationManager = (NotificationManager) mContext
            
        

                    .getSystemService(Context.NOTIFICATION_SERVICE);
        

            notificationManager.cancel(1337);
            
        

        } catch (Exception ex) {
                

        }
                

    }
                       



Set a ringtone/alarm or notification sound

                

 ContentValues values = new ContentValues();
        

                            values.put(MediaStore.MediaColumns.DATA, download_mp3_link);
            
        

                            values.put(MediaStore.MediaColumns.TITLE, song_name);
        

                            values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
            
        

                            values.put(MediaStore.Audio.Media.ARTIST, song_name);
        

                            values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
            
        

                            values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
        

                            values.put(MediaStore.Audio.Media.IS_ALARM, true);
            
        

                            values.put(MediaStore.Audio.Media.IS_MUSIC, true);
        

                            Uri uri = MediaStore.Audio.Media.getContentUriForPath(download_mp3_link);
            
        

                            Uri newUri = getContentResolver().insert(uri, values);
                

                            try {
            
        

                RingtoneManager.setActualDefaultRingtoneUri(mContext, RingtoneManager.TYPE_ALARM, newUri);
        

                                Toast.makeText(mContext, R.string.ringtone_set, Toast.LENGTH_LONG).show();
            
                

                            } catch (Throwable t) {
        

                                Toast.makeText(mContext, R.string.error_ringtone, Toast.LENGTH_LONG).show();
            
        

                            }
                       


Start the ads activity with a random number :)

                

 Random rand = new Random();
        

        int r_nr = rand.nextInt(10);
        

        if(r_nr == 1){
            
        

            startActivity(new Intent(mContext,ActivityAds.class));
        

        }
               



Play a radio from internet (or a stream)

                

 mPlayer = new MediaPlayer();
        

        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                

        try {
        

            mPlayer.setDataSource(MusicService.this, Uri.parse(url));
        

            mPlayer.prepare();
            
                

            mPlayer.start();
        

        } catch (IOException e) {
        

            //Log.e(TAG, "Could not open file for playback.");
            
        

            Toast.makeText(MusicService.this, "error connecting. try with a wi-fi connection...", Toast.LENGTH_LONG).show();
        

        }
            
                

        mPlayer.setOnErrorListener(this);
                

        mPlayer.setOnErrorListener(new OnErrorListener() {
                

            public boolean onError(MediaPlayer mp, int what, int extra) {
                

                onError(mPlayer, what, extra);
            
        

                return true;
        

            }
        

        });
            
                

    }
                

    public void pauseMusic() {
        

        if (mPlayer.isPlaying()) {
        

            mPlayer.pause();
        

            length = mPlayer.getCurrentPosition();
            
                

        }
        

    }
                

    public void resumeMusic() {
        

        if (mPlayer.isPlaying() == false) {
        

            mPlayer.seekTo(length);
        

            mPlayer.start();
            
        

        }
        

    }
                

    public void stopMusic() {
        


                        mPlayer.stop();
        

        mPlayer.release();
        

        mPlayer = null;
                

    }
                

    @Override
        

    public void onDestroy() {
        

        super.onDestroy();
            
                

        mNotificationManager.cancel(1773);
                

        if (mPlayer != null) {
        

            try {
        

                mPlayer.stop();
        

                mPlayer.release();
            
        

            } finally {
        

                mPlayer = null;
        

            }
            
        

        }
        

    }
                

    public boolean onError(MediaPlayer mp, int what, int extra) {
            
                

        Toast.makeText(this, "error on loading", Toast.LENGTH_SHORT).show();
        

        if (mPlayer != null) {
        

            try {
        

                mPlayer.stop();
        

                mPlayer.release();
            
        

            } finally {
        

                mPlayer = null;
        

            }
            
        

        }
        

        return false;
        

    }
                       


Share something

                

        Intent sharingIntent = new Intent(
        

                        Intent.ACTION_SEND);
            
        

                sharingIntent.setType("text/plain");
        

                String shareBody = "xxxxxxxxxx on Android https://play.google.com/store/apps/details?id=xxxxxxxxxx";
            
        

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,
        

                        "xxxxxxxxxxxxx");
            
        

                sharingIntent
        

                        .putExtra(Intent.EXTRA_TEXT, shareBody);
            
        

                startActivity(Intent.createChooser(sharingIntent,
        

                        "Choose sharing method"));
            
               



Very usefull library

                

https://code.google.com/p/android-query/
                

Please check it and use it :)
                

for example:
                

JSON (activity as callback)
                

public void asyncJson(){
            
        

       
        

        //perform a Google search in just a few lines of code
        

       
            
        

        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";            
        

        aq.ajax(url, JSONObject.class, this, "jsonCallback");
            
        

       
        

}
                

public void jsonCallback(String url, JSONObject json, AjaxStatus status){
        

       
        

        if(json != null){              
        

                //successful ajax call          
            
        

        }else{          
        

                //ajax error
        

        }
        

       
        

}
                       


Send a SMS

                

Uri smsUri = Uri.parse("sms:100861");
Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
intent.putExtra("sms_body", "shenrenkui");
startActivity(intent);
               



Get Battery Level

                

private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        

        @Override
        

        public void onReceive(Context ctx, Intent intent) {
        

          int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        

          Log.i("Battery Level", String.valueOf(level) + "%");
        

        }
        

      };
            
                       


Autostart app on boot

                

in AndroidManifest.xml (application-part):
                

<receiver android:enabled="true" android:name=".BootUpReceiver"
        

        android:permission="android.permission.RECEIVE_BOOT_COMPLETED">
                

        <intent-filter>
        

                <action android:name="android.intent.action.BOOT_COMPLETED" />
        

                <category android:name="android.intent.category.DEFAULT" />
            
        

        </intent-filter>
        

</receiver>
        

[..]
        

<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
            
                

public class BootUpReceiver extends BroadcastReceiver{
                

        @Override
        

        public void onReceive(Context context, Intent intent) {
            
        

                Intent i = new Intent(context, MyActivity.class);  
        

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            
        

                context.startActivity(i);  
        

        }
                

}
            
               



Setting toast to appear on some parts

                

Toast toast = Toast.makeText(context, "In Center", Toast.LENGTH_LONG);
                

//For Top
        

toast.setGravity(Gravity.TOP, 0, 0);
            
                

//For Center
        

toast.setGravity(Gravity.CENTER, 0, 0);
                

toast.show();
                       


Get phone last known location using Location Manager

                

private double[] getGPS() {
        

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
        

        List<String> providers = lm.getProviders(true);
                        

        /* Loop over the array backwards, and if you get an accurate location, then break out the loop*/
            
        

        Location l = null;
        

       
        

        for (int i=providers.size()-1; i>=0; i--) {
            
        

                l = lm.getLastKnownLocation(providers.get(i));
        

                if (l != null) break;
            
        

        }
        

       
        

        double[] gps = new double[2];
        

        if (l != null) {
        

                gps[0] = l.getLatitude();
        

                gps[1] = l.getLongitude();
            
        

        }
        

        return gps;
        

}
               



GPS Location with listener

                

locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                

// Define a listener that responds to location updates
        

locationListener = new LocationListener() {
        

        public void onLocationChanged(Location location) {
        

                // Called when a new location is found by the network location provider.
            
        

                longitude = String.valueOf(location.getLongitude());
        

                latitude = String.valueOf(location.getLatitude());
            
        

                Log.d(TAG, "changed Loc : " + longitude + ":" + latitude);
        

        }
                

        public void onStatusChanged(String provider, int status, Bundle extras) {
        

        }
                

        public void onProviderEnabled(String provider) {
        

        }
                

        public void onProviderDisabled(String provider) {
            
        

        }
        

};
                

// getting GPS status
        

isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            
                

// check if GPS enabled
        

if (isGPSEnabled) {
                

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            
                

        if (location != null) {
        

                longitude = String.valueOf(location.getLongitude());
            
        

                latitude = String.valueOf(location.getLatitude());
        

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            
        

        } else {
        

                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                

                if (location != null) {
            
        

                        longitude = String.valueOf(location.getLongitude());
        

                        latitude = String.valueOf(location.getLatitude());
            
        

                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        

                } else {
        

                        longitude = "0.00";
        

                        latitude = "0.00";
        

                }
        

        }
        

}
                       


Using Google Voice

                

@Override
        

public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                


                /* Call Activity to Open Google Voice */
        

Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                

intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
            
                

try {
        

    startActivityForResult(intent, 1);
        

} catch (ActivityNotFoundException a) {
        

    Log.d("LOG",a.getMessage());
        

}
                

}
                        

@Override
            
        

public void onActivityResult(int requestCode, int resultCode, Intent data) {
        

    super.onActivityResult(requestCode, resultCode, data);
                

    switch (requestCode) {
        

    case 1: {
        

        if (resultCode == Activity.RESULT_OK && null != data) {
            
                

            ArrayList text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                

           Log.d("LOG","You have speak  : "+text,get(0));
            
        

        }
        

        break;
        

    }
        

    }
        

}
               



Parsing / Reading XML file

        


        


        

<?xml version="1.0"?>


        

<cars>


        

    <car>


        

        <name>BMW</name>


        

        <grade>A</grade>


        

    </car>


        

    <car>


        

        <name>FORD</name>


        

        <grade>B</grade>


        

    </car>


        

    <car>


        

        <name>FIAT</name>


        

        <grade>C</grade>


        

    </car>


        

</cars>


        

import java.io.File;


        

import javax.xml.parsers.DocumentBuilder;


        

import javax.xml.parsers.DocumentBuilderFactory;


        

 


        

import org.w3c.dom.Document;


        

import org.w3c.dom.Element;


        

import org.w3c.dom.Node;


        

import org.w3c.dom.NodeList;


        

 


        

public class XMLParser {


        

 


        

    public void getAllUserNames(String fileName) {


        

        try {


        

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


        

            DocumentBuilder db = dbf.newDocumentBuilder();


        

            File file = new File(fileName);


        

            if (file.exists()) {


        

                Document doc = db.parse(file);


        

                Element docEle = doc.getDocumentElement();


        

 


        

                System.out.println("Root element of the document: "


        

                        + docEle.getNodeName());


        

 


        

                NodeList carList = docEle.getElementsByTagName("car");


        

 


        

                if (carList != null && carList.getLength() > 0) {


        

                    for (int i = 0; i < carList.getLength(); i++) {


        

 


        

                        Node node = carList.item(i);


        

 


        

                        if (node.getNodeType() == Node.ELEMENT_NODE) {


        

 


        

                           


        

                            Element e = (Element) node;


        

                            NodeList nodeList = e.getElementsByTagName("name");


        

                            System.out.println("Name: "


        

                                    + nodeList.item(0).getChildNodes().item(0)


        

                                            .getNodeValue());


        

 


        

                            nodeList = e.getElementsByTagName("grade");


        

                            System.out.println("Grade: "


        

                                    + nodeList.item(0).getChildNodes().item(0)


        

                                            .getNodeValue());


        

 


        

                                                  }


        

                    }


        

                } else {


        

                    System.exit(1);


        

                }


        

            }


        

        } catch (Exception e) {


        

            System.out.println(e);


        

        }


        

    }


        

    public static void main(String[] args) {


        

 


        

        XMLParser parser = new XMLParser();


        

        parser.getAllUserNames("test.xml");


        

    }


        

}
                               


Press once again to exit

                

private static long back_pressed;
                

@Override
        

public void onBackPressed()
        

{
        

        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        

        else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
            
        

        back_pressed = System.currentTimeMillis();
        

}
               



Send Email

        

import javax.mail.*;
        

import javax.mail.internet.*;
        

import java.util.*;
        

 
        

public void postMail( String recipients[ ], String subject, String message , String from) throws MessagingException
        

{
        

    boolean debug = false;
        

 
        

     Properties props = new Properties();
        

     props.put("mail.smtp.host", "smtp.example.com");
        

 
        

      Session session = Session.getDefaultInstance(props, null);
            
        

    session.setDebug(debug);
        

 
        

    Message msg = new MimeMessage(session);
        

   InternetAddress addressFrom = new InternetAddress(from);
        

    msg.setFrom(addressFrom);
        

 
        

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
        

    for (int i = 0; i < recipients.length; i++)
        

    {
        

        addressTo[i] = new InternetAddress(recipients[i]);
        

    }
        

    msg.setRecipients(Message.RecipientType.TO, addressTo);
        

    
        

 
        

   msg.addHeader("MyHeaderName", "myHeaderValue");
            
        

   msg.setSubject(subject);
        

    msg.setContent(message, "text/plain");
        

    Transport.send(msg);
            
        

}
                                       


Ask users to rate your app

                

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        

            @Override
            
        

            public void onClick(DialogInterface dialog, int which) {
        

                switch (which) {
        

                    case DialogInterface.BUTTON_POSITIVE:
                

                        try {
        

                            mp.stop();
            
        

                            mp.release();
        

                        } catch (Exception e) {
            
        

                            Log.e("EXCEPTION", "can't stop player");
        

                        }
            
                

                        try {
        

                            clearNotification();
            
        

                        } catch (Exception ex) {
                

                        }
            
                        

                        Random rand = new Random();
        

                        int r_nr = rand.nextInt(2);
            
        

                        if (r_nr == 1) {
        

                            startActivity(new Intent(mContext, ActivityAds.class));
            
        

                        }
        

                        finish();
            
                

                        break;
                

                    case DialogInterface.BUTTON_NEGATIVE:
            
                

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.bobysan.freemusicdownload"));
            
        

                        startActivity(browserIntent);
        

                        Toast.makeText(mContext, "Thank you very much", Toast.LENGTH_LONG).show();
            
        

                        break;
        

                }
        

            }
        

        };
                

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            
        

        builder.setMessage(getResources().getText(R.string.wemadethisappforfree)).setNegativeButton("Yes", dialogClickListener)
        

                .setPositiveButton(getResources().getText(R.string.later), dialogClickListener).show();
            

            
