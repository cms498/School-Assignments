let goodColor = "lightgreen"
let mediumColor = "LemonChiffon"
let fullColor = "red"

let goodText = "Welcome!"
let mediumText = "Warn the bouncers…"
let badText = "No one allowed in!"

let arcaneMax = 100
let arcaneMid = 70

let undergroundMax = 50
let undergroundMid = 30

let sodaMax = 20
let sodaMid = 12

let studioMax = 52
let studioMid = 32

function determineMessageAndColor(currentCount, midCount, maxCount, contentBox, contentMessage){
    let box = document.getElementById(contentBox)
    if (currentCount <= 0){
        box.style.backgroundColor = goodColor
        document.getElementById(contentMessage).innerHTML = ""
    }
    if(currentCount > 0 && currentCount < midCount){
        box.style.backgroundColor = goodColor
        document.getElementById(contentMessage).innerHTML = goodText
    }
    if (currentCount >= midCount && currentCount < maxCount){
        box.style.backgroundColor = mediumColor
        document.getElementById(contentMessage).innerHTML = mediumText
    }
    if(currentCount >= maxCount){
        box.style.backgroundColor = fullColor
        document.getElementById(contentMessage).innerHTML = badText
    }
}

function determineCount(button, currentCount){
    if(button.value == "+"){
        let val = parseInt(currentCount.innerText)
        val += 1
        currentCount.innerHTML = val
    } else if (button.value == '-'){
        let val = parseInt(currentCount.innerText)
        val -= 1
        currentCount.innerHTML = val
    }
}

function changeBox(button){
    var button_choice = document.getElementById(button)
    var radio_choice = document.querySelectorAll('input[name="clubs"]')
    let club_choice
    for(const radioButton of radio_choice){
        if(radioButton.checked){
            club_choice = radioButton.value
        }
    }
    if(club_choice == "clubArcane"){
        let count = document.getElementById("arcaneCount")
        determineCount(button_choice, count)
        determineMessageAndColor(count.innerText, arcaneMid, arcaneMax, "arcaneContent", "arcaneMessage")
    } else if (club_choice == "clubUnderground"){
        let count = document.getElementById("undergroundCount")
        determineCount(button_choice, count)
        determineMessageAndColor(count.innerText, undergroundMid, undergroundMax, "undergroundContent", "undergroundMessage")
    } else if (club_choice == 'clubSoda'){
        let count = document.getElementById("sodaCount")
        determineCount(button_choice, count)
        determineMessageAndColor(count.innerText, sodaMid, sodaMax, "sodaContent", "sodaMessage")
    } else if(club_choice == 'studio52'){
        let count = document.getElementById("studioCount")
        determineCount(button_choice, count)
        determineMessageAndColor(count.innerText, studioMid, studioMax, "studioContent", "studioMessage")
    }
}