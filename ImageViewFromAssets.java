 try {
InputStream ims = getAssets().open("ic_launcher.png");
Drawable d = Drawable.createFromStream(ims, null);
imgView.setImageDrawable(d);
}
catch(IOException ex) {
return;

}
