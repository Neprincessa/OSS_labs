'use strict';
// создаем <link rel="stylesheet" href="light|dark.css">
let head = document.head,
    link = document.createElement('link');
link.rel = 'stylesheet';
// проверяем значение из localStorage если dark то темная тема
if (localStorage.getItem('themeStyle') === 'dark') {
    link.href = '../static/css/dark.css'; // ссылка на темный стиль
    document.getElementById('switch-1').setAttribute('checked', true); // переключаем чекбокс в положение "темная тема"
}
// по умолчанию светлая тема
else {
    link.href = '../static/css/light.css'; // ссылка на светлый стиль
}
head.appendChild(link); // вставляем <link rel="stylesheet" href="light|dark.css"> в шапку страницы между темаги head

// событие при переключении чекбокса
document.getElementById('switch-1').addEventListener('change', ev => {
    let btn = ev.target;
    // если чекбокс включен
    if (btn.checked) {
        link.href = '../static/css/dark.css'; // включаем темную тему
        localStorage.setItem('themeStyle', 'dark'); // записываем значение в localStorage
    }
    else {
        link.href = '../static/css/light.css'; // включаем светлую тему
        localStorage.setItem('themeStyle', 'light'); // записываем значение в localStorage
    }
});