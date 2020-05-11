# HTML의 핵심 개념인 Hyperlink

- HyperText의 Hyper는 컴퓨터 용어로서 텍스트 등의 정보가 동일 선상에 있는 것이 아니라 다중으로 연결되어 있는 상태를 의미한다.
- HTML의 가장 중요한 특징인 link의 개념과 연결되는데, 기존 문서나 텍스트의 선형성, 고정성의 제약에서 벗어나 사용자가 원하는 순서대로 정보를 취득할 수 있는 기능을 제공한다.
- 한 텍스트에서 다른 텍스트로 건너뛰어 읽을 수 있는 기능을 <b>하이퍼링크(hyper link)</b>라 한다.
- HTML link는 hyperlink를 의미하며 a(anchor) tag가 그 역할을 담당한다.

```html
<!DOCTYPE html>
<html>
    <body>
        <a href="http://www.google.com">Visit google.com!</a>
    </body>
</html>
```

![](./img/link.PNG)

# href 어트리뷰트

- href 어트리뷰트는 이동하고자 하는 파일의 위치(경로)를 값으로 받는다.
  - 경로(path)란 파일 시스템 상에서 특정 파일의 위치를 의미

## 디렉터리 (Directory)

- 디렉터리는 파일과 다른 디렉터리를 갖느 ㄴ파일 시스템 내의 존재물로서 폴더라고도 불린다.
  - 루트 디렉터리
    - 파일 시스템 계층 구조 상의 최상위 디렉터리
      - Unix: /
      - Windows: C:\
  - 홈 디렉터리
    - 시스템의 사용자에게 각각 할당된 개별 디렉터리
      - Unix: /Users/{계정명}
      - Windows: C:\Users\{계정명}
  - 작업 디렉터리
    - 작업 중인 파일의 위치한 디렉터리
      - ./
  - 부모 디렉터리
    - 작업 디렉터리의 부모 디렉터리
      - ../

## 파일 경로 (File path)

- 파일 경로는 파일 시스템에서 파일의 위치를 나타내는 방법이다.
- 경로에는 절대경로와 상대경로가 있다.
  - 절대경로(Absolute path)
    - 현재 작업 디렉터리와 관계없이 특정 파일의 절대적인 위치를 가리킨다.
    - 루트 디렉터리를 기준으로 파일의 위치를 나타낸다.
      - http://www.mysite.com/index.html
      - /Users/seungbin/Desktop/myImage.jpg
      - C:\Users\seungbin\Desktop\myImage.jpg
      - /index.html
  - 상대경로(Relative path)
    - 현재 작업 디렉터리를 기준으로 특정 파일의 상대적인 위치를 가리킨다.
      - ./index.html
      - ../dist/index.js
      - ../../dist/index.js
      - index.html
      - html/index.html

- href 어트리뷰트에 사용 가능한 값

| Value               | Description                                               |
| ------------------- | --------------------------------------------------------- |
| 절대 URL            | 웹사이트 URL (herf="http://www.example.com/default.html") |
| 상대 URL            | 자신의 위치를 기준으로 한 URL(href="html/default.html")   |
| fragment identifier | 페이지 내의 특정 id를 갖는 요소에의 링크(href="#top")     |
| 메일                | mailto                                                    |
| script              | href="javascript:alert('Hello');"                         |

```html
<!DOCTYPE html>
<html>
    <body>
        <a href="http://www.google.com">URL</a><br>
        <a href="html/my.html">Local file</a><br>
        <a href="file/my.pdf" download>download file</a><br>
        <a href="#">fragment identifier</a><br>
        <a href="mailto:someone@example.com?Subject=Hello again">Send Mail</a><br>
        <a href="javascript:alert('Hello');">javascript</a>
    </body>
</html>
```

- fragment identifier를 이용한 페이지 내부 이동 방법

```html
<!DOCTYPE html>
<html>
<body>

<h2 id="top">Top of page!</h2>

<p>
    ~~~~
    </p>

<a href="#top">Go to top</a> <!-->클릭시 top으로 감<-->
</body>
</html>
```

## target 어트리뷰트

target 어트리뷰트는 링크를 클릭했을 때 윈도우를 어떻게 오픈할 지를 지정한다.

| Value  | Description                                                |
| ------ | ---------------------------------------------------------- |
| _self  | 링크를 클릭했을 때 연결문서를 현재 윈도우에서 오픈(기본값) |
| _blank | 링크를 클릭했을 때 연결문서를 새로운 윈도우나 탭에서 오픈  |

```html
<!DOCTYPE html>
<html>
    <body>
        <a href="http://www.google.com" target="_blank">Visit google.com</a>
    </body>
</html>
```

