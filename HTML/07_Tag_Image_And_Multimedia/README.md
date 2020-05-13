# 이미지 표현,동영상, 음악 등 멀티미디어 지원 태그

# 이미지

- 웹페이지에 이미지를 삽입하는 경우, img tag를 사용한다.

| attribute | Description                                  |
| --------- | -------------------------------------------- |
| src       | 이미지 파일 경로                             |
| alt       | 이미지 파일이 없을 경우 표시되는 문장        |
| width     | 이미지의 너비 (CSS에서 지정하는 것이 일반적) |
| height    | 이미지의 높이 (CSS에서 지정하는 것이 일반적) |

```html
<!DOCTYPE html>
<html>
    <body>
        <img src="assets/images/multimedia.png" alt="multimedia icon" width="100">
        <img src="assets/images/wrongname.gif" alt="이미지가 없습니다.">
    </body>
</html>
```

<!DOCTYPE html>
    <html>
    <body>
        <img src="assets/images/multimedia.png" alt="multimedia icon" width="100">
        <img src="assets/images/wrongname.gif" alt="이미지가 없습니다.">
    </body>
</html>
</!doctype>


# 미디어

- audio 태그는 HTML5에서 새롭게 추가된 태그이다.
  - IE8 이하에서는 사용할 수 없다.

| arribute | Description                                   |
| -------- | --------------------------------------------- |
| src      | 음악 파일 경로                                |
| preload  | 재생 전에 음악 파일을 모두 불러올 것인지 지정 |
| autoplay | 음악 파일을 자동 재생할 것인지 지정           |
| loop     | 음악을 반복할 것인지 지정                     |
| controls | 음악 재생 도구를 표시할 것인지 지정.          |

```html
<!DOCTYPE html>
<html>
    <body>
        <audio src="assets/audio/beet.wav" controls></audio>
    </body>
</html>
```

<!DOCTYPE html>
<html>
    <body>
        <audio src="assets/audio/beet.wav" controls></audio>
    </body>
</html>
</!doctype>


- 웹 브라우저 별로 지원하는 음악 파일 형식이 다르다.
  - 파일 형식에 따라 재생되지 않는 브라우저가 존재한다는 뜻

| Browser           | MP3  | Wav  | Ogg  |
| ----------------- | ---- | ---- | ---- |
| Internet Explorer | YES  | NO   | NO   |
| Chrome            | YES  | YES  | YES  |
| Firefox           | YES  | YES  | YES  |
| Safari            | YES  | YES  | NO   |
| Opera             | YES  | YES  | YES  |

- source 태그를 사용하여 파일 형식의 차이 문제를 해결 할 수 있다.
- type 어트리뷰트는 생략 가능

```html
<!DOCTYPE html>
<html>
    <body>
        <audio controls>
            <source src="assets/audio/beet.wav" type="audio/mpeg">
        </audio>
    </body>
</html>
```

<!DOCTYPE html>
<html>
    <body>
        <audio controls>
            <source src="assets/audio/beet.wav" type="audio/mpeg">
        </audio>
    </body>
</html>
</!doctype>


## 비디오

- video 태그는 HTML5에서 새롭게 추가된 태그이다.
  - IE8 이하에서는 사용할 수 없다.

| attribute | Description                                     |
| --------- | ----------------------------------------------- |
| src       | 동영상 파일 경로                                |
| poster    | 동영상 준비 중에 표시될 이미지 파일 경로        |
| preload   | 재생 전에 동영상 파일을 모두 불러올 것인지 지정 |
| autoplay  | 동영상 파일을 자동 재생할 것인지 지정           |
| loop      | 동영상을 반복할 것인지 지정                     |
| controls  | 동영상 재생 도구를 표시할 것인지 지정           |
| width     | 동영상의 너비를 지정                            |
| height    | 동영상의 높이를 지정                            |

- audio 태그와 마찬가지로 파일 형식의 차이 문제가 발생할 수 있다.
  - source 태그를 사용하여 형식 차이 문제를 해결한다. type 어트리뷰트는 생략 가능

| Browser           | MP4  | WebM | Ogv  |
| ----------------- | ---- | ---- | ---- |
| Internet Explorer | YES  | NO   | NO   |
| Chrome            | YES  | YES  | YES  |
| Firefox           | YES  | YES  | YES  |
| Safari            | YES  | NO   | NO   |
| Opera             | YES  | YES  | YES  |

```html
<!DOCTYPE html>
<html>
    <body>
        <video width="640" height="360" controls>
            <source src="assets/video/Nature.mp4" type="video/mp4">
        </video>
    </body>
</html>
</!doctype>
```

<!DOCTYPE html>
<html>
    <body>
        <video width="640" height="360" controls>
            <source src="assets/video/Nature.mp4" type="video/mp4">
        </video>
    </body>
</html>