 Get all the files:-
try {
String[] files = getAssets().list("");
for(int i=0; i<files.length; i++){
System.out.println(files[i]);
}
}
catch (IOException e1) {
e1.printStackTrace();
}
Use getAssets().list("foldername"); to get data from a particular folder.


To load text file:-
InputStream input;
try {
input = getAssets().open(fileName);
int size = input.available();
byte[] buffer = new byte[size];
input.read(buffer);
input.close();
String text = new String(buffer);
}
catch (IOException e) {
e.printStackTrace();
}



To load image file:-
try {
InputStream ims = getAssets().open("ic_launcher.png");
Drawable d = Drawable.createFromStream(ims, null);
imgView.setImageDrawable(d);
}
catch(IOException ex) {
return;

}
