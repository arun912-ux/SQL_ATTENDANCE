



/*
 * Typical pin layout used:
 * -----------------------------------------------------------------------------------------
 *             MFRC522      Arduino       Arduino   Arduino    Arduino          Arduino
 *             Reader/PCD   Uno/101       Mega      Nano v3    Leonardo/Micro   Pro Micro
 * Signal      Pin          Pin           Pin       Pin        Pin              Pin
 * -----------------------------------------------------------------------------------------
 * RST/Reset   RST          9             5         D9         RESET/ICSP-5     RST
 * SPI SS      SDA(SS)      10            53        D10        10               10
 * SPI MOSI    MOSI         11 / ICSP-4   51        D11        ICSP-4           16
 * SPI MISO    MISO         12 / ICSP-1   50        D12        ICSP-1           14
 * SPI SCK     SCK          13 / ICSP-3   52        D13        ICSP-3           15
 */

#include <SPI.h>
#include <MFRC522.h>
#include <SD.h>
#include <RTClib.h>
#include <Wire.h>


#define RST_PIN         9          // Configurable, see typical pin layout above
#define SS_PIN          10         // Configurable, see typical pin layout above
#define SS_SD_PIN       7

MFRC522 mfrc522(SS_PIN, RST_PIN);  // Create MFRC522 instance
RTC_DS3231 RTC;


void setup() {
  
  Serial.begin(9600);   // Initialize serial communications with the PC
  while (!Serial);    // Do nothing if no serial port is opened (added for Arduinos based on ATMEGA32U4)

  SPI.begin();        // Init SPI bus
  RTC.begin();
  SD.begin(SS_SD_PIN);
  
//  Wire.begin();
  
  if (RTC.lostPower()) {        // no !
    //delay(2000);
    Serial.println(F("RTC lost power, let's set the time!"));
    RTC.adjust(DateTime(F(__DATE__), F(__TIME__)));
  }
  
  mfrc522.PCD_Init();   // Init MFRC522
  
  delay(4);       // Optional delay. Some board do need more time after init to be ready, see Readme
  
  mfrc522.PCD_DumpVersionToSerial();  // Show details of PCD - MFRC522 Card Reader details
  
  Serial.println(F("Scan PICC to see UID, SAK, type, and data blocks..."));
}

void loop() {
  DateTime now= RTC.now();
  char s[30];

  if( mfrc522.PICC_IsNewCardPresent()) {
    unsigned long uid = getUID();
    if(uid != -1){
//      sprintf(s, "Time : %02d:%02d:%02d", now.hour(),now.minute(), now.second());  Serial.println(s);
      Serial.println(uid);
//      storeToSD(uid);
    }
  }

}

unsigned long getUID(){
  if ( ! mfrc522.PICC_ReadCardSerial()) {
    return -1;
  }
  unsigned long hex_num;
  hex_num =  mfrc522.uid.uidByte[0] << 24;
  hex_num += mfrc522.uid.uidByte[1] << 16;
  hex_num += mfrc522.uid.uidByte[2] <<  8;
  hex_num += mfrc522.uid.uidByte[3];
  mfrc522.PICC_HaltA(); // Stop reading
  return hex_num;
}




/*
#include <SPI.h>
#include <SD.h>
#include <RTClib.h>


void storeToSD(unsigned long uid){
  DateTime now = RTC.now();
  char s[20];
  File myFile = SD.open("attendance.txt", FILE_WRITE);
  sprintf(s, "%lu,%02d:%02d:%02d", uid, now.hour(),now.minute(), now.second());
  myFile.println(s);
  
  myFile.close();
  
}
*/