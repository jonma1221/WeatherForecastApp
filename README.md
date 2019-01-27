# WeatherForecastApp
#Install
1.Find the github's repository url
2.Click the clone or download button and click download zip
3.Extract the zip file
5.Open Android studio and import the project you just downloaded
6.Sync gradle
7.Run the project on emulator or device
or
1. locate apk AndroidStudioProjects/WeatherForecastApp/app/build/outputs/apk/debug/app-debug.apk
2. install and run apk

#Use
You can search by city name and it will display the current day weather as well as the forecast for
the next 5 days.

#Features
- can search by city name
- display information such as date, weather and description, wind speed/direction as well as 3 hour
  updates for the current day
- shows the icons for the weather condition

#Improvements
- Offline search and cache to avoid redundant search
- Handling rotation so that information isn't refetched when the fragment is recreated
- Adding an option to use current location, but that would also involve handling runtime permissions
- Search by zip code and coordinates in addition to name
- Change the background color depending on the current weather and time
- Localization of units depending on the user's device
- adding more functionality to the 5 day forecast, like clicking on a certain day will bring up more
  details for that day
- better error handling, right now just shows generic error message
- add placeholders for images and text while loading the next city's weather
