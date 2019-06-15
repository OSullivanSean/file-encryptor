<h1> file-encryptor </h1>

<p>
a tool that provides data scrambling encryption and decryption.<br>
the tool will make an encrypted/decrypted copy of the target file, not encrypt/decrypt the target file itself.<br>
use case is for copy of sensitive files to external (3rd party cloud) storage<br>
'scrambling' is achieved through char value(as int) incrementation based on hashed key.<br>
'un-scrambling' is acheived through char value(as int) decrementation based on hashed key.<br><br>
</p>

<h2>usage</h2>

<p>
to encrypt a file<br>
<i><b>java -jar fileToEncrypt</b></i>
</p>

<p>
to decrypt a file<br>
<i><b>java -jar fileToDecrypt -d</b></i>
</p>

<p>
to create and encrypted copy of a file<br>
<i><b>java -jar fileToEncrypt outputFileName</b></i>
</p>

<p>
to create and encrypted copy of a file<br>
<i><b>java -jar fileToDencrypt outputFileName -d</b></i>
</p>