# pscAutomation

Simple JAVA library using pschll32.dll to connect and interact with Personal Communication terminal from IBM. 

It should allow to connect with:
WinHLLAPI, EHLLAPI, Attachmate HLLAPI,
Enterprise Access Library (EAL), PCSHLL (IBM PCOMM 4.01 EHLLAPI), or WD_API
(Wall Data abstraction of HLLAPI).

(personally tested on Personal Communication only) 


pschll32 API can be found:


https://docs.attachmate.com/extra/x-treme/apis/pcshll.pdf


https://www.ibm.com/docs/en/personal-communications/6.0?topic=programming-introduction-standard-ehllapi-enhanced-ehllapi-winhllapi

### requirements
* JDK 32 bit is needed to be able to load .*hll32.dll 
* PCSHLL32.DLL, EHLAPI32.DLL or WHLAPI32.DLL. I tested only frist one but IBM datasheet says that the main difference between them is different name for entry point (hllapi / winhllapi)

### usage
```
try (Pschll32Proxy proxy = new Pschll32Proxy("A")) {
  proxy.setPosition(10, 10);
  proxy.sendAt("someText", 20, 20);
} catch (Exception ex) {
  // some code
}
```
