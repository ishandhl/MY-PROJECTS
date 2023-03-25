
//api key from google
const apiKey = "218f8c4487ee1ffbcb836edb87ee1d43";

const apiUrl = "https://api.openweathermap.org/data/2.5/weather?units=metric&q=";

//The first line selects an input element with the class "search" using the .search input selector, and assigns it to the variable searchBox.
const searchBox = document.querySelector(".search input");
const searchBtn = document.querySelector(".search button");
const weatherIcon = document.querySelector(".weather-icon");

//this function check wather from provided api 
async function checkWeather(city){
  const response = await fetch(apiUrl + city + `&appid=${apiKey}`);
  var data = await response.json();

 console.log(data);

  document.querySelector(".city").innerHTML = data.name;
  document.querySelector(".temp").innerHTML = Math.round(data.main.temp) + "°C";
  document.querySelector(".humidity").innerHTML = data.main.humidity + "%";
  document.querySelector(".wind").innerHTML = data.wind.speed + "km/h";


//different image for different weather using conditions.
  if(data.weather[0].main == "Clouds"){
    weatherIcon.src = "images/clouds.png";
  
}
  else if(data.weather[0].main == "Clear"){
    weatherIcon.src = "images/clear.png";
    
  }
  else if(data.weather[0].main == "Rain"){
    weatherIcon.src ="images/rain.png";
    

  }
  else if(data.weather[0].main == "Drizzle"){
    weatherIcon.src = "image/drizzle.png";
    

  }
  else if(data.weather[0].main == "Mist"){
    weatherIcon.src = "images/mist.png";
    

  }
}


searchBtn.addEventListener("click", ()=>{
checkWeather(searchBox.value);
})