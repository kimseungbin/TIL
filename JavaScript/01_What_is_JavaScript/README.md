# 자바스크립트의 탄생

- 1995년 당시 약 90%의 시장 점유율로 웹 브라우저 시장을 지배하고 있던 Netscape comunications는 정적인 HTML을  
  동적으로 표현하기 위해 경량의 프로그래밍 언어를 도입하기로 결정했고, 그래서 탄생한 것이 Brendan Eich가 개발한 자바스크립트
- 자바스크립트는 1996년 3월 넷스케이프 커뮤니케이션즈의 웹 브라우저인 Netscape Navigator 2에 탑재
  - "Mocha"로 명명되었고, 9월 "LiveScript"로 이름이 변경되었고, 12월 "JavaScript"로 최종 명명됨
- 현재 모든 브라우저의 표준 프로그래밍 언어가 되었으나 순탄하게 성장했던 것은 아님
  - 자바스크립트가 탄생한 뒤 얼마 지나지 않아 자바스크립트의 파생 버전인 JScript가 출시되 위기를 맞는다.

# 자바스크립트의 파편화와 표준화

- 1996년 8월 마이크로스프트는 자바 스크립트 파생 버전인 "JScript"를 Internet Explorer 3.0에 탑재
  - JScript와 자바스크립트가 표준화되지 못하고 적당히 호환되었다는게 문제.  
    즉, 자사 브라우저의 시장 점유율을 점유하기 위해 자사 브라우저에서만 동작하는 기능을 경쟁적으로 추가하기 시작했다.
  - 이로인해 브라우저에 따라 웹 페이지가 정상 동작하지 않는 크로스 브라우징 이슈가 발생
    - 모든 브라우저에서 동작하는 웹 페이지를 개발하는 것이 무척 어려워졌다.
- 자바스크립트의 파편화를 방지하고 모든 브라우저에서 동일하게 동작하는 표준화된 자바스크립트에 대한 필요성이 제기
  - 1996년 11월 Netscape comunications는 컴퓨터 시스템의 표준을 관리하는 비영리 표준화 기구인 ECMA 인터내셔널에 자바스크립트의 표준화를 요청
- 1997년 7월, ECMA-262라 불리는 표준화된 자바스크립트 초판(ECMAScript 1)의 명세가 완성되었다.
  - 상표권 문제로 자바스크립트는 ECMAScript로 명명되었다.
  - 이후 1999년 ECMAScript 3(ES3)이 공개되었고 10년 만인 2009년 출시된 ES5는 HTML5와 함께 출현한 표준안이다.
- 2015년 ECMAScript 6가 공개
  - 범용 프로그래밍 언어로서 갖추어야 할 let / const 키워드, 화살표 함수, 클래스, 모듈 등과 같은 기능들을 대거 도입하는 큰 변화가 있었다.

# 자바스크립트 성장의 역사

- 초창기 자바스크립트는 웹 페이지의 보조적인 기능을 수행하기 위해 한정적인 용도로 사용되었다.
  - 이 시기에 대부분의 로직은 주로 웹 서버에서 실행되었고 브라우저는 서버로부터 전달받은 HTML과 CSS를 단순히 렌더링하는 수준이였다.
- 1999년 자바스크립트를 이용해 비동기적(Asynchronous)으로  
  서버와 브라우저가 데이터를 교환할 수 있는 통신 기능인 Ajax(Asynchronous JavaScript and XML)가 XMLHttpRequest이라는 이름으로 등장
- 이전의 웹 페이지는 서버로부터 완전한 HTML을 받아 웹 페이지 전체를 렌더링하는 방식으로 동작
  - 따라서 화면이 전환되면 서버로부터 새로운 HTML을 전송 받아 웹 페이지 전체를 처음부터 다시 렌더링하였다.
  - 변경이 없는 부분까지 포함된 HTML을 서버로부터 다시 전송 받기 때문에 불필요한 데이터 통신이 발생,  
    변경이 없는 부분까지 처음부터 다시 렌더링해야 하기 때문에 퍼포먼스 측면에서도 불리한 방식이였다.
  - 화면 전환이 일어나면 화면이 순간적으로 깜박이는 현상이 발생하고, 이는 웹 애플리케이션의 한계로 받아들여 졌다.
- Ajax의 등장은 웹 페이지의 변경이 필요 없는 부분은 다시 렌더링하지 않고,  
  서버로부터 필요한 데이터만을 전송 받아 변경이 필요한 부분만을 한정적으로 렌더링하는 방식이 가능해졌다.
  - 이로 인해 웹 브라우저에서도 데스크톱 애플리케이션과 유사한 빠른 퍼포먼스와 부드러운 화면 전환이 가능하게 되었다.
- 2005년 구글이 발표한 Google Maps는 웹 애플리케이션 개발 프로그래밍 언어로서 자바스크립트의 가능성을 확인하는 계기를 마련했다.
  - 웹 브라우저에서 자바스크립트와 Ajax를 기반으로 동작하는 Google Maps가 데스크톱 애플리케이션과 비교해 손색이 없을 정도의 퍼포먼스와 부드러운 화면 전환 효과를 보여줌
- 2006년 JQuery의 등장으로 다소 번거롭고 논란이 있던 DOM(Document Object Model)을 보다 쉽게 제어할 수 있게 되었다.
  - 크로싱 브라우징 이슈도 어느정도 해결되었다.
  - JQuery는 넓은 사용자 층을 순식간에 확보해 당시 까다로운 자바스크립트보다 배우기 쉽고 직관적인 JQuery를 더 선호하는 개발자가 양산되기도 함
- Google Maps를 통해 가능성이 확인된 자바스크립트로 웹 애플리케이션을 구축하려는 시도가 늘어갔다.
  - 보다 빠르게 동작하는 자바스크립트 엔진이 요구되었다.
    - 2008년 구글의 V8 자바스크립트 엔진은 이러한 요구에 부합하는 빠른 성능을 보여주었다.
- V8 자바스크립트 엔진의 등장으로 자바스크립트는 데스크톱 애플리케이션과 유사한 사용자 경험을 제공할 수 있는 웹 애플리케이션 개발 프로그래밍 언어로 정착하게 되었다.
- V8 자바스크립트 엔진으로 촉발된 자바스크립트의 발전으로 과거 웹 서버에서 수행되던 역할들이 클라이언트(브라우저)로 이동
  - 이로써 웹 애플리케이션에서 프런트엔드 영역이 주목받는 계기가 됨
- 2009년 브라우저에서만 동작하던 자바스크립트를 브라우저 이외의 환경에서 동작시킬 수 있는 자바스크립트 실행 환경인 Node.js의 등장으로 자바스크립트는 웹 브라우저를 벗어나 서버 사이드 애플리케이션 개발에서도 사용되는 범용 프로그래밍 언어가 되었다.
  - 웹 브라우저에서만 동작하는 반쪽짜리 프로그래밍 언어 취급을 받던 자바스크립트는 프런트엔드 영역은 물론 백엔드 영역까지 아우르는 웹 프로그래밍 언어의 표준으로 자리잡고 있다.
- 자바스크립트는 크로스 플랫폼을 위한 가장 중요한 언어로 주목받고 있다.
- 이제 웹 애플리케이션은 데스크톱 애플리케이션과 비교해도 손색없는 성능과 사용자 경험을 제공하는 것이 필수가 되었다.
  - 개발 규모와 복잡도도 더불어 상승
  - 이전의 개발 방식으로는 복잡해진 개발 과정을 수행하기 어려워졌고, 이러한 필요에 따라 많은 패턴과 라이브러리가 출현
    - 이는 개발에 많은 도움을 주었지만 유연하면서 확장이 쉬운 애플리케이션 아키텍쳐 구축을 어렵게 하였다.
    - 필연적으로 프레임워크가 등장하게 됨
    - SPA(Single Page Application)가 대중화되면서 Angular, React, Vue.js 등 다양한 SPA 프레임워크/라이브러리 또한 많은 사용층을 확보하고 있다.

# JavaScript와 ECMAScript

- ECMAScript는 자바스크립트의 표준 명세인 ECMA-262를 말한다.
  - 프로그래밍 언어의 타입, 값, 객체와 프로퍼티, 함수, 빌트인 객체 등 핵심 문법(core systax)을 규정한다.
  - 각 브러우저 제조사는 ECMAScript를 준수하여 브라우저에 내장되는 자바스크립트 엔진을 구현한다
- 자바스크립트는 일반적으로 프로그래밍 언어로서 기본 뼈대를 이루는 ECMAScript와 브라우저가 별도 지원하는 클라이언트 사이드 Web API,  
  즉 DOM, BOM, Canvas, XMLHttpRequest, Fetch, requestAnimationFrame, SVG, Web Storage, Web Component, Web worker 등을 아우르는 개념
- 클라이언트 사이드 Web API
  - ECMAScript와는 별도로 World Wide Web Consortium(W3C)에서 별도의 명세로 관리하고 있다.
  - 서버로부터 받아온 후 클라이언트에 의해 실행된다.

# 자바스크립트의 특징

- 자바스크립트는 HTML, CSS와 함께 웹을 구성하는 요소 중 하나로 웹 브라우저에서 동작하는 유일한 프로그래밍 언어이다.
  - 기존의 프로그래밍 언어에서 많은 영향을 받았다.
- 자바스크립트는 개발자가 별도의 컴파일 작업을 수행하지 않는 인터프리터 언어(Interperter Language)이다.
- 자바스크립트는 명령형(imperactive), 함수형(functional), 프로토타입 기반(prototype-based) 객체지향 프로그래밍을 지원하는 멀티 패러다임 프로그래밍 언어

