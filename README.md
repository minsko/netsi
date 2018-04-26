# NETSI

This is a basic sample to demonstrate an issue in Apktool v2.3.2.

Apktool v2.3.2 does not appear to properly handle `assets`.
The asset file still exists, but it can't be loaded.

`java.io.FileNotFoundException: This file can not be opened as a file descriptor; it is probably compressed`

The asset works properly in v2.3.1