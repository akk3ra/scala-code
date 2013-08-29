import javax.net.ssl.SSLSocketFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
class Client {
	def main(args:Array[String]){
		val ssf = SSLSocketFactory.getDefault()
		val ss = ssf.createSocket("localhost",1234)
		val is = System.in
		val br = new BufferedReader(new InputStreamReader(is))
		val os = ss.getOutputStream
		val bw = new BufferedWriter(new OutputStreamWriter(os))
		var line:String = null
		while((line = br.readLine())!=null){
			
			bw.write(line)
			bw.flush()
		}
	}
}
