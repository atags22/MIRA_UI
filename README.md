I added a submodule for HID stuff.

If there's no folder called "hid4java", I think you'll need to invoke some linear combination of the following lines until all the submodules work:

git submodule init
git submodule update

After init'ing and updating, from intellij:
New -> Module from existing sources -> Find the file "pom.xml" INSIDE pc_MIRA/hid4java -> OK -> Check "Search for projects recursively" and "Import Maven projects automatically" -> Next -> Finish

If it doesn't work, open the file that is causing errors and use alt-space and start praying.
