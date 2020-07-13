# 객체

- 자바스크립트엔 여덟 가지 자료형이 있다.
  - 이 중 일곱 개는 오직 하나의 데이터(문자열, 숫자 등)만 담을 수 있어 원시형(primitive type)이라 부른다.
- 객체형은 원시형과 달리 다양한 데이터를 담을 수 있다.
  - 키로 구분된 데이터 집합이나 복잡한 객체(entity)를 저장할 수 있다.
  - 객체는 자바스크립트 거의 모든 면에 녹아있는 개념이므로 자바스크립트를 잘 다루려면 객체를 잘 이해하고 있어야 한다.
- 객체는 중괄호 `{...}`를 이용해 만들 수 있다.
  - 중괄호 안에는 `키(key): 값(value)` 쌍으로 구성된 프로퍼티(property)를 여러 개 넣을 수 있다.
  - `키`엔 문자형, `값`엔 모든 자료형이 허용된다.
  - 프로퍼티 키는 프로퍼티 이름이라고도 부른다.
- 서랍장 안 파일은 프로퍼티, 파일 각각에 붙어있는 이름표는 객체의 키라고 생각하면 된다.
  - 복잡한 서랍장 안에서 이름표를 보고 원하는 파일을 쉽게 찾을 수 있듯, 객체에선 키를 이용해 프로퍼티를 쉽게 찾을 수 있다.

```javascript
// 빈 객체를 만드는 두 가지 방법
let user = new Object(); // '객체 생성자' 문법
let user = {}; // '객체 리터럴' 문법
```

- 중괄호 `{ ... }`를 이용해 객체를 선언하는 것을 객체 리터럴 이라고 부른다.
  - 객체를 선언할 땐 주로 이 방법을 사용한다.

## 리터럴과 프로퍼티

- 중괄호 `{ ... }`안에는 `키: 값` 쌍으로 구성된 프로퍼티가 들어간다.

```javascript
let user = {     // 객체
	name: "John",  // 키: "name",  값: "John"
	age: 30        // 키: "age", 값: 30
};
```

- `콜론(:)`을 기준으로 왼쪽엔 키, 오른쪽엔 값이 위치
  - 프로퍼티 키는 프로퍼티 이름 혹은 식별자라고도 부른다.
- 만들어진 객체 `user`에는 두 개의 프로퍼티가 있다.
  1. 첫 번째 프로퍼티 - "name"(이름)과 "John"(값)
  2. 두 번째 프로퍼티 = "age"(이름)과 30(값)
- 서랍장(객체) 안에 파일 두 개(프로퍼티 두 개)가 담겨있는데, 각 파일에 "name", "age"라는 이름표가 붙어있다고 생각하면 쉽다.
- 서랍장에 파일을 추가하고 뺄 수 있듯 프로퍼티를 추가, 삭제할 수 있다.
- 점 표기법(dot notation)을 이용하면 프로퍼티 값을 읽는 것도 가능

```javascript
// 프로퍼티 값 얻기
alert(user.name); // John
alert(user.age); // 30
```

- 프로퍼티 값엔 모든 자료형이 올 수 있다.

```javascript
// 불린형 프로퍼티 추가
user.isAdmin = true;
```

- `delete` 연산자를 사용하면 프로퍼티를 삭제할 수 있다.

```javascript
delete user.age;
```

- 여러 단어를 조합해 프로퍼티 이름을 만든 경우엔 프로퍼티 이름을 따옴표로 묶어줘야 한다.

```javascript
let user = {
	name: "John",
	age: 30,
	"likes birds": true // 복수 단어는 따옴표로 묶는다.
};
```

- 마지막 프로퍼티 끝은 쉼표로 끝날 수 있다.

```javascript
let user = {
  name: "John",
  age: 30,
}
```

- 이런 쉼표를 trailing(길게 늘어지는) 혹은 hanging(매달리는) 쉼표라고 부른다.
  - 끝에 쉼표를 붙이면 모든 프로퍼티가 유사한 형태를 보이기 때문에 프로퍼티를 추가, 삭제, 이동하는 게 쉬워진다.

---

- `const`로 선언된 객체는 수정할 수 있다.
  - Object 자체가 할당되는 게 아니라 Object의 주소가 할당된다.
  - 주소값은 불변이고, 상수이지만 Object에 Key-Value 쌍을 추가하거나 변경하는 행위는 당연하다.
  - `user = ....` 처럼 다시 설정하는 경우에 에러가 난다.

```javascript
const user = {
  name: "John",
};

user.name = "Pete";

alert(user.name); // Pete
```

## 대괄호 표기법

- 여러 단어를 조합해 프로퍼티 키를 만든 경우, 점 표기법을 사용해 프로퍼티 값을 읽을 수 없다.

```javascript
// 문법 에러 발생
user.likes birds = true;
```

- 점(.)은 유효한 변수 식별자인 경우에만 사용할 수 있다.
  - 유효한 변수 식별자엔 공백이 없어야 한다.
  - 숫자로 시작하지 않아야 하며 `$`와 `_`를 제외한 특수 문자가 없어야 한다.
- 키가 유효한 변수 식별자가 아닌 경우
  - 점 표기법 대신 대괄호 표기법이라 불리는 방법을 사용할 수 있다.
  - 대괄호 표기법은 키에 어떤 문자열에 있던지 상관없이 동작한다.

```javascript
let user = {};

// set
user["likes birds"] = true;

// get
alert(user["likes birds"]); // true

// delete
delete user["likes birds"];
```

- 대괄호 표기법 안에서 문자열을 사용할 땐 문자열을 따옴표로 묶어줘야 한다.
  - 따옴표의 종류는 상관없다.
- 대괄호 표기법을 사용하면 변수를 키로 사용한 것과 같이 문자열뿐만 아니라 모든 표현식의 평가를 프로퍼티 키로 사용할 수 있다.

```javascript
let key = "likes birds";

// user["likes birds"] = true; 와 같다.
user[key] = true;
```

- 변수 `key`는 런타임에 평가되기 때문에 사용자 입력값 등에 따라 값이 변경될 수 있다.
  - 어떤 경우든 평가가 끝난 이후의 결과가 프로퍼티 키로 사용된다.
- 응용한 예시

```javascript
let user = {
	name: "John",
	age: 30
};

let key = prompt("사용자의 어떤 정보를 얻고 싶으신가요?", "name");

// 변수로 접근
alert(user[key]); // John (프롬프트 창에 "name"을 입력한 경우)

// 점 표기법은 이런 방식이 불가능하다.
let key = "name";
alert(user.key) // undefined
```

## 계산된 프로퍼티

- 객체를 만들 때 객체 리터럴 안의 프로퍼티 키가 대괄호로 둘러싸여 있는 경우, 이를 계산된 프로퍼티(computed property)라고 부른다.

```javascript
let fruit = prompt("어떤 과일을 구매하시겠습니까?", "apple");

let bag = {
	[fruit]: 5, // 변수 fruit에서 프로퍼티 이름을 동적으로 받아온다.
};

alert(bag.apple); // fruit에 "apple"이 할당되었다면, 5가 출력
```

- `[fruit]`는 프로퍼티 이름을 변수 `fruit`에서 가져오겠다는 것을 의미한다.
  - 사용자가 프롬프트 대화상자에 `apple`를 입력했다면 bag에는 `{apple: 5}`가 할당

```javascript
// 위 예시와 동일하게 동작하는 코드
let fruit = prompt("어떤 과일을 구매하시겠습니까?", "apple");
let bag = {};

// 변수 fruit을 사용해 프로퍼티 이름을 만든다.
bag[fruit] = 5;
```

- 대괄호 안에는 복잡한 표현식이 올 수도 있다.

```javascript
let fruit = 'apple';
let bag = {
	[fruit + 'Computers']: 5 // bag.appleComputers = 5
};
```

- 대괄호 표기법은 프로퍼티 이름과 값의 제약을 없애주기 때문에 점 표기법보다 훨씬 강력하다.
  - 하지만 작성하기 번거롭다는 단점이 있다.
- 프로퍼티 이름이 확정된 상황이고, 단순한 이름이라면 점 표기법을 사용하다가 복잡한 상황이 발생했을 때 대괄호 표기법으로 바꾸는 경우가 많다.

## 단축 프로퍼티

- 실무에선 프로퍼티 값을 기존 변수에서 받아와 사용하는 경우가 종종 있다.

```javascript
function makeUser(name, age) {
	return {
		name: name,
		age: age,
		// ...등등
	};
}

let user = makeUser("John", 30);
alert(user.name); // John
```

- 프로퍼티들의 이름과 값이 변수의 이름과 동일하다.
  - 이렇게 변수를 사용해 프로퍼티를 만드는 경우는 아주 흔한데, 프로퍼티 값 단축 구문을 사용하면 짧게 줄일 수 있다.

```javascript
function makeUser(name, age) {
	return {
		name, // name: name 과 같음
		age,  // age: age 와 같음
		// ...
	};
}
```

- 한 객체에서 일반 프로퍼티와 단축 프로퍼티를 함께 사용하는 것도 가능하다.

```javascript
let user = {
	name,  // name: name 과 같음
	age: 30
};
```

- 프로퍼티 이름의 제약사항
  - 변수 이름(키)엔 `for`, `let`, `return`같은 예약어를 사용하면 안된다.
  - 그런데 객체 프로퍼티엔 이런 제약이 없다.

```javascript
// 예약어를 키로 사용해도 괜찮다.
let obj = {
	for: 1,
	let: 2,
	return: 3
};

alert(obj.for + obj.let + obj.return);  // 6
```

- 프로퍼티 이름엔 특별한 제약이 없다.
  - 어떤 문자형, 심볼형 값도 프로퍼티 키가 될 수 있다.
  - 문자형이나 심볼형에 속하지 않은 값은 문자열로 자동 형 변환된다.

```javascript
// 키에 숫자 0을 넣으면 문자열 "0"으로 자동 변환된다.
let obj = {
	0: "test" // "0": "test"와 동일
};

// 숫자 0은 문자열 "0"으로 변환되기 때문에 두 얼럿 창은 같은 프로퍼티에 접근
alert( obj["0"] ); // test
alert( obj[0] ); // test (동일한 프로퍼티)
```

- 객체 프로퍼티 키에 쓸 수 있는 문자열엔 제약이 없지만, 역사적인 이유 때문에 특별 대우를 받는 이름이 하나 있다.
  - `__proto__`

```javascript
let obj = {};
obj.__proto__ = 5; // 숫자를 할당
alert(obj.__proto__); /* 결과: [object Object]
					숫자를 할당했지만 값은 객체가 되었다.
					의도한대로 동작하지 않는다. */
```

- 원시값 `5`를 할당했는데 무시된 것을 확인할 수 있다.

## in 연산자로 프로퍼티 존재 여부 확인하기

- 자바스크립트 객체의 중요한 특징 중 하나
  - 다른 언어와는 달리 존재하지 않는 프로퍼티에 접근하려 해도 에러가 발생하지 않고 `undefined`를 반환한다.
  - 이런 특징을 응용하면 프로퍼티 존재 여부를 쉽게 확인할 수 있다.

```javascript
let user = {};

alert(user.noSuchProperty === undefined); // true는 '프로퍼티가 존재하지 않음'을 의미
```

- `undefine`와 비교하는 것 이외에도 연산자 `in`을 사용하면 프로퍼티 존재 여부를 확인할 수 있다.

```javascript
// 문법
"key" in object
```

- 예시

```javascript
let user = {
    name: "John",
    age: 30,
};

alert("age" in user); // user.age가 존재하므로 true
alert("blabla" in user); // user.blabla는 존재하지 않기 때문에 false
```

- `undefined`와 비교해도 충분한데 왜 `in` 연산자가 있을까?
  - 대부분의 경우, 일치 연산자를 사용해서 프로퍼티 존재 여부를 알아내는 방법은 꽤 잘 동작한다.
  - 하지만 가끔 실패할 때도 있다. 이럴 때 `in`을 사용하면 프로퍼티 존재 여부를 제대로 판별할 수 있다.
- 프로퍼티는 존재하는데, 값에 `undefined`를 할당한 예시

```javascript
let obj = {
	test: undefined
};

alert(obj.test); // 값이 `undefined`이므로, 얼럿 창엔 undefined가 출력. 그런데 프로퍼티 test는 존재

alert("test" in obj); // `in`을 사용하면 프로퍼티 유무를 제대로 확인할 수 있다(true).
```

## for ... in 반복문

- `for..in` 반복문을 사용하면 객체의 모든 키를 순회할 수 있다.
  - `for (; ;)`반복문과는 완전히 다르다.

```javascript
for (key in object) {
  // 각 프로퍼티 키(key)를 이용하여 본문(body)을 실행
}
```

- 예시

```javascript
let user = {
	name: "John",
	age: 30,
	isAdmin: true,
};

// 객체 user의 모든 프로퍼티가 출력된다.
for (let key in user) { // 반복 변수선언(let key)
	// 키
	alert(key);  // name, age, isAdmin
	// 키에 해당하는 값
	alert(user[key]); // John, 30, true
}
```

## 객체 정렬 방식

- 프로퍼티엔 순서가 있을까?
  - 반복문은 프로퍼티를 추가한 순서대로 실행될까? 이 순서는 항상 동일할까?
- 객체는 '특별한 방식으로 정렬'된다.
  - 정수 프로퍼티는 자동으로 정렬되고, 그 외의 프로퍼티는 객체에 추가한 순서 그대로 정렬된다.

```javascript
// 국제전화 나라 번호가 담겨있는 예제
let codes = {
	"49": "독일",
	"41": "스위스",
	"44": "영국",
	// ..,
	"1": "미국"
};

for (let code in codes) {
  alert(code); // 1, 41, 44, 49
}
```

- 만약 개발 중인 애플리케이션의 주 사용자가 동일인이면 나라 번호를 선택하는 화면에서 `49`가 맨 앞에 오도록 하는게 좋을 것이다.
  - 하지만 코드를 실행해 보면 예상과는 전혀 다른 결과가 출력된다.
    - 미국(1)이 첫 번째로 출력
    - 그 뒤로 스위스(41), 영국(44), 독일(49)이 차례대로 출력
  - 이유는 나라 번호(키)가 정수여서 `1, 41, 44, 49`순으로 프로퍼티가 자동 정렬되었기 때문이다.

---

- 정수 프로퍼티?
  - 정수 프로퍼티라는 용어는 변형 없이 정수에서 왔다 갔다 할 수 있는 문자열을 의미한다.
  - 문자열 "49"는 정수로 변환하거나 변환한 정수를 다시 문자열로 바꿔도 변형이 없기 때문에 정수 프로퍼티이다.
    - 하지만 "+49"와 '1.2'는 정수 프로퍼티가 아니다.

```javascript
// 함수 Math.trunc는 소수점 아래를 버리고 숫자의 정수부만 반환
alert( String(Math.trunc(Number("49"))) ); // '49'가 출력. 기존에 입력한 값과 같으므로 정수 프로퍼티
alert( String(Math.trunc(Number("+49"))) ); // '49'가 출력. 기존에 입력한 값(+49)과 다르므로 정수 프로퍼티
alert( String(Math.trunc(Number("1.2"))) ); // '1'이 출력. 기존에 입력한 값(1.2)과 다르므로 정수 프로퍼티
```

---

- 정수 키가 아닌 경우 작성된 순서대로 프로퍼티가 나열된다.

```javascript
let user = {
	name: "John",
	surname: "Smith"
};
user.age = 25; // 프로퍼티를 하나 추가

// 정수 프로퍼티가 아닌 프로퍼티는 추가된 순서대로 나열된다.
for (let prop in user) {
  alert(prop); // name, surname, age
}
```

- 독일 나라번호(49)를 가장 위에 출력되도록 하려면 나라 번호가 정수로 취급되지 않도록 속임수를 쓰면 된다.
  - 각 나라 앞에 `"+"`를 붙여보자.

```javascript
let codes = {
	"+49": "독일",
	"+41": "스위스",
	"+44": "영국",
	// ..,
	"+1": "미국",
};

for (let code in codes) {
  alert(+code); // 49, 41, 44, 1
}
```

# 참조에 의한 객체 복사

- 객체와 원시 타입의 근본적인 차이 중 하나는 객체는 참조에 의해 저장되고 복사된다는 것
  - 원시값은 값 그대로 저장/할당되고 복사된다.

```javascript
let message = "Hello!";
let phrase = message;
// 두 개의 독립된 변수에 각각 문자열 "Hello!"가 저장된다.
```

- 객체는 변수에 그대로 저장되는 것이 아니라, 객체가 저장되어있는 메모리주소인 객체에 대한 참조값이 저장된다.
  - 따라서 객체가 할당된 변수를 복사할 땐 객체의 참조 값이 복사되고 객체는 복사되지 않는다.

```javascript
let user = {
    name: "John",
};

let admin = user; // 참조값을 복사함
```

- 객체에 접근하거나 객체를 조작할 땐 여러 변수를 사용할 수 있다.

```javascript
let user = {
    name: 'John',
};

let admin = user;

admin.name = 'Pete'; // 'admin' 참조 값에 의해 변경됨

alert(user.name); // 'Pete'가 출력됨. 'user' 참조 값을 이용해 변경사항을 확인
```

- 객체를 서랍장에 비유하면 변수는 서랍장을 열 수 있는 열쇠이다.
  - 서랍장은 하나, 서랍장을 열 수 있는 열쇠는 여러개인데, 그 중 하나를 사용해 서랍장을 열어 정돈한 후,  
    다른 열쇠로 서랍장을 열면 정돈된 내용을 볼 수 있다.

## 참조에 의한 비교

- 객체 비교 시 동등 연산자 `==`와 일치 연산자`===`는 동일하게 동작한다.
  - 비교 시 피연산자인 두 객체가 동일한 객체인 경우 참을 반환

```javascript
// 두 변수가 같은 객체를 참조하는 예시
let a = {};
let b = a; // 참조에 의한 복사

alert( a == b ); // true, 두 변수는 같은 객체를 참조
alert( a === b ); // true
```

```javascript
// 다른 예시
let a = {};
let b = {}; // 독립된 두 객체

alert( a == b ); // false
```

- `obj1 > obj2` 같은 대소 비교나 `obj == 5`같은 원시값과의 비교에선 객체가 원시형으로 변환된다.
  - 이러한 비교가 필요한 경우는 매우 드물다(대개 코딩 실수 때문에 이런 비교가 발생).

## 객체 복사, 병합과 Object.assign

- 객체가 할당된 변수를 복사하면 동일한 객체에 대한 참조 값이 하나 더 만들어지는데,  
  객체를 복제하고 싶다면?
  - 기존에 있던 객체와 똑같으면서 독립적인 객체를 만들고싶다면.
- 자바스크립트는 객체 복제 내장 메서드를 지원하지 않기 때문에 조금 어렵다.
  - 사실 객체를 복제해야 할 일은 거의 없다.
  - 참조에 의한 복사로 해결 가능한 일이 대다수이다.
- 정말 복제가 필요한 상황이라면
  - 새로운 객체를 만든 다음 기존 객체의 프로퍼티들을 순회해 원시 수준까지 프로퍼티를 복사하면 된다.

```javascript
let user = {
	name: "John",
	age: 30
};

let clone = {}; // 새로운 빈 객체

// 빈 객체에 user 프로퍼티 전부를 복사해 넣는다.
for (let key in user) {
	clone[key] = user[key];
}

// 이제 clone은 완전히 독립적인 복제본이 되었다.
clone.name = "Pete"; // clone의 데이터를 변경

alert(user.name); // 기존 user객체에는 여전히 John이 있다.
```

- Object.assign을 사용하는 방법도 있다.

```javascript
// 문법
Object.assign(dest, [src1, src2, src3 ...])
```

- 첫 번째 인수 `dest`는 목표로 하는 객체
- 이어지는 인수 `src1, ..., srcN`은 복사하고자 하는 객체
  - `...`은 필요에 따라 얼마든지 많은 객체를 인수로 사용할 수 있다는 것을 나타낸다.
- 객체 `src1, ..., srcN`의 프로퍼티를 `dest`에 복사한다.
  - `dest`를 제외한 인수(객체)의 프로퍼티 전부가 첫 번째 인수(객체)로 복사된다.
- 마지막으로 `dest`를 반환한다.

```javascript
// assgin 메서드를 사용해 여러 객체를 하나로 병합하는 예시
let user = {
    name: "John",
};

let permissions1 = {
    canView: true,
};
let permissions2 = {
    canEdit: true,
};

// permissions1과 permissions2의 프로퍼티를 user로 복사
Object.assign(user, permissions1, permissions2);

// now user = { name: "John", canView: true, canEdit: true }
```

- 목표 객체(`user`)에 동일한 이름을 가진 프로퍼티가 있는 경우 기존 값이 덮어씌워진다.

```javascript
let user = {
    name: "John",
};

Object.assign(user, { name: "Pete" });

alert(user.name); // user = { name: "Pete" }
```

- `Object.assign`을 사용하면 반복문 없이도 간단하게 객체를 복사할 수 있다.

```javascript
let user = {
	name: "John",
	age: 30,
};

let clone = Object.assign({}, user);
```

## 중첩 객체 복사

- 프로퍼티는 다른 객체에 대한 참조 값일 수도 있다.

```javascript
let user = {
	name: "John",
	sizes: {
		height: 182,
		width: 50
	}
};

alert(user.sizes.height); // 182
```

- `clone.sizes = user.sizes`로 프로퍼티를 복사하는 것만으론 객체를 복사할 수 없다.
  - `user.sizes`는 객체이기 때문에 참조 값이 복사된다.
  - `clone.sizes = user.sizes`로 프로퍼티를 복사하면 `clone`과 `user`는 같은 sizes를 공유하게 된다.

```javascript
let user = {
	name: "John",
	sizes: {
		height: 182,
		width: 50
	}
};

let clone = Object.assign({}, user);

alert(user.sizes === clone.sizes); // true, 같은 객체

// user와 clone는 sizes를 공유
user.sizes.width++;       // 한 객체에서 프로퍼티를 변경
alert(clone.sizes.width); // 51, 다른 객체에서 변경 사항을 확인할 수 있다.
```

- 이런 문제를 해결하려면?
  - `user[key]`의 각 값을 검사하면서 그 값이 객체인 경우 객체의 구조도 복사해주는 반복문을 사용해야 한다.
  - 이런 방식을 깊은 복사라고 한다.
- 깊은 복사 시 사용되는 표준 알고리즘인 [Structured cloning algorithm](https://html.spec.whatwg.org/multipage/structured-data.html#safe-passing-of-structured-data)[Structured cloning algorithm](https://html.spec.whatwg.org/multipage/structured-data.html#safe-passing-of-structured-data)을 사용하면 다양한 상황에서 객체를 복제할 수 있다.
- 자바스크립트 라이브러리 [lodash](https://lodash.com/)의 메서드인 [_.cloneDeep(obj)](https://lodash.com/docs#cloneDeep)을 사용하면 알고리즘을 직접 구현하지 않고도 깊은 복사를 처리할 수 있다.

```javascript
const _ = require("lodash")

const clone6 = _.cloneDeep(original)

console.log(original.func) // function func()
console.log(clone6.func) // function func()
```

# 가비지 컬렉션

- 자바스크립트는 눈에 보이지 않는 곳에서 메모리 관리를 수행한다.
- 원시값, 객체, 함수 등 우리가 만드는 모든 것은 메모리를 차지한다.
  - 그렇다면 더는 쓸모 없어지게 된 것들은 어떻게 처리될까?

## 가비지 컬렉션 기준

- 자바스크립트는 도달 가능성이라는 개념을 사용해 메모리 관리를 수행한다.
- 도달 가능한 값
  - 쉽게 말해 어떻게든 접근하거나 사용할 수 있는 값을 의미한다.
  - 도달 가능한 값은 메모리에서 삭제되지 않는다.

1. 태생부터 도달 가능하기 때문에, 명백한 이유 없이 삭제되지 않는것들
   - 현재 함수의 지역 변수와 매개변수
   - 중첩 함수의 체인에 있는 함수에서 사용되는 변수와 매개변수
   - 전역 변수
   - 기타 등등
   - 이런 값은 루트(root)라고 부른다.
2. 루트가 참조하는 값이나 체이닝 등으로 루트에서 참조할 수 있는 값은 도달 가능한 값이 된다.
   - 지역 변수에 객체가 저장되어있다고 가정.
   - 이 객체의 프로퍼티가 또 다른 객체를 참조하고 있다면, 프로퍼티가 참조하는 객체는 도달 가능한 값이 된다.  
     이 객체가 참조하는 다른 모든 것들도 도달 가능하다고 여겨진다.

- 자바스크립트 엔진 내에선 가비지 컬렉터가 끊임없이 동작한다.
  - 가비지 컬렉터는 모든 객체를 모니터링하고, 도달할 수 없는 객체는 삭제한다.

## 간단한 예시

```javascript
// user엔 객체 참조 값이 저장된다.
let user = {
	name: "John"
};
```

- 전역 변수 `user`는 `{name: "John"}` (줄여서 John)이라는  객체를 참조한다.
  - John의 프로퍼티 `name`은 원시값을 저장하고 있다.
- `user`의 값을 다른 값으로 덮어쓰면 참조가 사라진다.

```javascript
user = null;
```

- 이제 John은 도달할 수 없는 상태가 되었다.
  - John에 접근할 방법도, John을 참조하는 것도 모두 사라졌다.
  - 가비지 컬렉터는 John에 저장된 데이터를 삭제하고, John을 메모리에서 삭제한다.

## 참조 두 개

- 참조를 `user`에서 `admin`으로 복사했다고 가정

```javascript
// user엔 객체 참조 값이 저장
let user = {
	name: "John"
};

let admin = user;
```

- `user`의 값을 다른 값으로 덮어쓰면?

```javascript
user = null;
```

- 전역 변수 `admin`을 통하면 여전히 객체 John에 접근할 수 있기 때문에 John은 메모리에서 삭제되지 않는다.
  - 이 상태에서 `admin`을 다른 값(null 등)으로 덮어쓰면 John은 메모리에서 삭제될 수 있다.

## 연결된 객체

- 가족관계를 나타내는 복잡한 예시

```javascript
function marry(man, woman) {
  woman.husband = man;
  man.wife = woman;

  return {
    father: man,
    mother: woman
  }
}

let family = marry({
  name: "John"
}, {
  name: "Ann"
});
```

- 함수 `marry`는 매개변수로 받은 두 객체를 서로 참조하게 하면서 결혼시키고, 두 객체를 포함하는 새로운 객체를 반환한다.
  - 이 상태에서는 모든 객체가 도달 가능한 상태

```javascript
// 참조 두 개를 지우기
delete family.father;
delete family.mother.husband;
```

- John으로 들어오는 참조는 모두 사라져 John은 도달 가능한 상태에서 벗어난다.
- 외부로 나가는 참조는 도달 가능한 상태에 영향을 주지 않는다.
  - 외부에서 들어오는 참조만이 도달 가능한 상태에 영향을 준다.
  - 그러므로 메모리에서 제거된다.
  - John에 저장된 데이터(프로퍼티) 역시 메모리에서 사라진다.

## 도달할 수 없는 섬

- 객체들이 연결되어 섬 같은 구조를 만드는데, 이 섬에 도달할 방법이 없는 경우, 섬을 구성하는 객체 전부가 메모리에서 삭제된다.

```javascript
// 근원 객체 family가 아무것도 참조하지 않도록할 때
family = null;
```

- 도달할 수 없는 섬 예제는 도달 가능성이라는 개념이 얼마나 중요한지 보여준다.
  - John과 Ann은 여전히 서로를 참조하고 있고, 두 객체 모두 외부에서 들어오는 참조를 가지고 있지만, 이것만으론 충분하지 않다.
  - `family` 객체와 루트의 연결이 사라지면 루트 객체를 참조하는 것이 아무것도 없게된다.
    - 섬 전체가 도달할 수 없는 상태가 되고, 섬을 구성하는 객체 전부가 메모리에서 제거된다.

# 메서드와 'this'

- 객체는 사용자(user), 주문(order) 등과 같이 실제 존재하는 개체(entity)를 표현하고자 할 때 생성된다.

```javascript
let user = {
    name: "John",
    age: 30,
};
```

- 사용자는 현실에서 장바구니 물건 선택하기, 로그인하기, 로그아웃하기 등의 행동을 한다.
  - 이와 마찬가지로 사용자를 나타내는 객체 user도 특정한 행동을 할 수 있다.
- 자바스크립트에선 객체의 프로퍼티에 함수를 할당해 객체에게 행동할 수 있는 능력을 부여해준다

## 메서드 만들기

- 객체 `user`에게 인사할 수 있는 능력을 부여해주자

```javascript
let user = {
    name: "John",
    age: 30,
};

user.sayHi = function() {
    alert("안녕하세요!");
};

user.sayHi(); // 안녕하세요!
```

- 함수 표현식으로 함수를 만들고, 객체 프로퍼티 `user.sayHi`에 함수를 할당하였다.
  - 이렇게 객체 프로퍼티에 할당된 함수를 메서드(method)라고 부른다.
- 메서드는 이미 정의된 함수를 이용해서 만들 수도 있다.

```javascript
let user = {
    // ...
};

// 함수 선언
function sayHi() {
    alert("안녕하세요!");
};

// 선언된 함수를 메서드로 등록
user.sayHi = sayHi;

user.sayHi(); // 안녕하세요!
```

---

- 객체 지향 프로그래밍
  - 객체를 사용하여 개체를 표현하는 방식을 객체 지향 프로그래밍(object-oriented programming, OOP)이라고 부른다.
  - OOP는 그 자체만으로도 학문의 분야를 만드는 중요한 주제이다.
    - 올바른 개체를 선택하는 방법, 개체 사이의 상호작용을 나타내는 방법 등에 관한 의사결정은 객체 지향 설계를 기반으로 이뤄진다.

---

## 메서드 단축 구문

- 객체 리터럴 안에 메서드를 선언할 때 사용할 수 있는 단축 문법

```javascript
// 아래 두 객체는 동일하게 동작한다.

user = {
    sayHi: function() {
        alert("Hello");
    }
};

// 단축 구문을 사용
user = {
    sayHi() { // "sayHi: function()"과 동일
        alert("Hello");
    }
};
```

- 일반적인 방법과 단축 구문을 사용한 방법이 완전히 동일하진 않다.
  - 객체 상속과 관련된 미묘한 차이가 존재

## 메서드와 'this'

- 메서드는 객체에 저장된 정보에 접근할 수 있어야 제 역할을 할 수 있다.
  - 모든 메서드가 그런건 아니지만, 대부분의 메서드가 객체 프로퍼티의 값을 활용한다.
  - `user.sayHi()`의 내부 코드에서 객체 `user`에 저장된 이름(name)을 이용해 인사말을 만드는 경우가 이런 경우에 해당
- <b>메서드 내부에서 `this` 키워드를 사용하면 객체에 접근할 수 있다.</b>
  - '점 앞'의`this`는 객체를 나타낸다. 정확히는 메서드를 호출할 때 사용된 객체

```javascript
let user = {
    name: "John",
    age: 30,

    sayHi() {
        // 'this'는 '현재 객체'를 나타낸다.
        alert(this.name);
    }

};

user.sayHi(); // John
```

- `user.sayHi()`가 실행되는 동안에 `this`는 `user`를 나타낸다.
  - `this`를 사용하지 않고 외부 변수를 참조해 객체에 접근하는 것도 가능하다.

```javascript
let user = {
    name: "John",
    age: 30,

    sayHi() {
        alert(user.name); // 'this' 대신 'user'를 이용
    }

};
```

- 그런데 외부 변수를 사용해 객체를 참조하면 예기치 못한 에러가 발생할 수 있다.
  - `user`를 복사해 다른 변수에 할당(`admin = user`)하고, `user`는 전혀 다른 값으로 덮어썼다고 가정하면 `sayHi()`는 원치 않는 값을 참조한다.

```javascript
let user = {
    name: "John",
    age: 30,

    sayHi() {
        alert( user.name ); // Error: Cannot read property 'name' of null
    }

};


let admin = user;
user = null; // user를 null로 덮어쓴다.

admin.sayHi(); // sayHi()가 엉뚱한 객체를 참고하면서 에러가 발생
```

## 자유로운 'this'

- 자바스크립트의 `this`는 다른 프로그래밍 언어의 `this`와 동작 방식이 다르다.
  - 자바스크립트에선 모든 함수에 `this`를 사용할 수 있다.

```javascript
// 문법 에러가 발생하지 않는다.
function sayHi() {
    alert(this.name);
}
```

- `this`값은 런타임에 결정된다.
  - 컨텍스트에 따라 달라진다.
- 동일한 함수라도 다른 객체에서 호출했다면 'this'가 참조하는 값이 달라진다.

```javascript
let user = {
    name: "John",
};
let admin = {
    name: "Admin",
};

function sayHi() {
    alert( this.name );
}

// 별개의 객체에서 동일한 함수를 사용함
user.f = sayHi;
admin.f = sayHi;

// 'this'는 '점(.) 앞의' 객체를 참조하기 때문에
// this 값이 달라짐
user.f(); // John  (this == user)
admin.f(); // Admin  (this == admin)

admin['f'](); // Admin (점과 대괄호는 동일하게 동작함)
```

---

- 객체 없이 호출하기: this == undefined
  - 객체가 없어도 함수를 호출할 수 있다.

```javascript
function sayHi() {
    alert(this);
}

sayHi(); // undefined
```

- 엄격 모드에서 실행하면, `this`엔 `undefined`가 할당된다.
  - `this.name`으로 name에 접근하려고 하면 에러발생
- 엄격 모드가 아닐 때는 `this`가 전역 객체를 참조한다.
  - 브라우저 환경에선 `window`라는 전역 객체를 참조한다.
  - 이런 동작 차이는 "use strict"이 도입된 배경이기도 하다.
- 이런 식의 코드는 대개 실수로 작성된 경우가 많다.
  - 함수 본문에 `this`가 사용되었다면, 객체 컨텍스트 내에서 함수를 호출할 것이라고 예상하면 된다.

---

- 자유로운 `this`가 만드는 결과
  - 다른 언어를 사용하다가 자바스크립트로 넘어오면 `this`를 혼동하기 쉽다.
    - `this`는 항상 메소드가 정의된 객체를 참조할 것이라고 착각할 수 있다.
    - 이런 개념을 'bound `this`'라고 한다.
  - 자바스크립트에서 `this`는 런타임에 결정된다.
    - 메서드가 어디서 정의되었는지에 상관없이 `this`는 '점 앞의' 객체가 무엇인가에 따라 '자유롭게' 결정된다.
  - `this`가 런타임에 결정되면 좋은 점도 있고 나쁜 점도 있다.
    - 함수(메서드)를 하나만 만들어 여러 객체에서 재사용할 수 있다는 것이 장점
    - 이런 유연함이 실수로 이어질 수 있다는 것은 단점
  - 자바스크립트가 `this`를 다루는 방식이 좋은지, 나쁜지는 판단할 문제가 아니다.
    - 개발자는 `this`의 동작 방식을 충분히 이해하고 장점을 취하면서 실수를 피하는 데만 집중하면 된다.

---

## 'this'가 없는 화살표 함수

- 화살표 함수는 일반 함수와는 달리 '고유한' `this`를 가지지 않는다.
  - 화살표 함수에서 `this`를 참조하면, 화살표 함수가 아닌 '평범한' 외부 함수에서 `this`값을 가져온다.

```javascript
// 함수 arrow()의 this는 외부 함수 user.sayHi()의 this가 된다.
let user = {
    firstName: "보라",
    sayHi() {
        let arrow = () => alert(this.firstName);
        arrow();
    }
};

user.sayHi(); // 보라
```

- 별개의 `this`가 만들어지는 건 원하지 않고, 외부 컨텍스트에 있는 `this`를 이용하고 싶은 경우 화살표 함수가 유용하다.

---

# 'new' 연산자와 생성자 함수

- 객체 리터럴 `{ ... }`을 사용하면 객체를 쉽게 만들 수 있다.
  - 그런데 개발을 하다 보면 유사한 객체를 여러 개 만들어야 할 때가 생기곤 한다.
  - 복수의 사용자, 메뉴 내 다양한 아이템을 객체로 표현하려고 하는 경우
- `new` 연산자와 생성자 함수를 사용하면 유사한 객체 여러 개를 쉽게 만들 수 있다.

## 생성자 함수

- 생성자 함수와 일반 함수에 기술적인 차이는 없다.
  - 다만 생성자 함수는 두 관례를 따른다.
    1. 함수 이름의 첫 글자는 대문자로 시작한다.
    2. 반드시 `"new"` 연산자를 붙여 실행한다.

```javascript
function User(name) {
    this.name = name;
    this.isAdmin = false;
}

let user = new User("Jack");

alert(user.name); // Jack
alert(user.isAdmin); // false
```

- `new User(...)` 를 써서 함수를 실행하면 아래와 같은 알고리즘이 동작한다.
  1. 빈 객체를 만들어 `this`에 할당한다.
  2. 함수 본문을 실행한다. `this`에 새로운 프로퍼티를 추가해 `this`를 수정한다.
  3. `this`를 반환한다.

```javascript
// 과정 예시
function User(name) {
    // this = {};  (빈 객체가 암시적으로 만들어짐)

    // 새로운 프로퍼티를 this에 추가함
    this.name = name;
    this.isAdmin = false;

    // return this;  (this가 암시적으로 반환됨)
}
```

- `let user = new User("Jack")`은 아래처럼 동일하게 동작한다.

```javascript
let user = {
    name: "Jack",
    isAdmin: false
};
```

- `new User("Jack")`이외에도 `new User("Ann")`, `new User("Alice")`등을 이용하면 손쉽게 사용자 객체를 만들 수 있다.
  - 객체 리터럴 문법으로 일일이 객체를 만드는 방법보다 훨씬 간단하고 읽기 쉽게 객체를 만들 수 있다.
- 생성자의 의의는 바로 재사용할 수 있는 객체 생성 코드를 구현하는 것이다.
- 모든 함수는 생성자 함수가 될 수 있다.
  - `new`를 붙여 실행한다면 어떤 함수라도 위의 알고리즘이 실행된다.
  - 첫 글자가 대문자인 함수는 `new`를 붙여 실행해야 한다. 공동의 약속.

---

- new function() { ... }
  - 재사용할 필요가 없는 복잡한 객체를 만들어야 할 때를 생각해보자.
  - 많은 양의 코드가 필요할 건데, 이럴 땐 아래처럼 코드를 익명 생성자 함수로 감싸주는 방식을 사용할 수 있다.

```javascript
let user = new function() {
    this.name = "John";
    this.isAdmin = false;

    // 사용자 객체를 만들기 위한 여러 코드.
    // 지역 변수, 복잡한 로직, 구문 등의
    // 다양한 코드가 여기에 들어간다.
};
```

- 위의 생성자 함수는 익명 함수이기 때문에 어디에도 저장되지 않는다.
  - 처음 만들 때부터 단 한 번만 호출할 목적으로 만들었기 때문에 재사용이 불가능하다.
  - 이렇게 익명 생성자 함수를 이용하면 재사용은 막으면서 코드를 캡슐화 할 수 있다.

---

## new.target과 생성자 함수

- `new.target` 프로퍼티를 사용하면 함수가 `new`와 함께 호출되었는지 아닌지를 알 수 있다
  - 일반적인 방법으로 함수를 호출했다면 `new.target`은 undefined를 반환한다.
  - 반면 `new`와 함께 호출한 경우엔 `new.target`은 함수 자체를 반환해준다.

```javascript
function User() {
    alert(new.target);
}

// "new" 없이 호출함
User(); // undefined

//"new"를 붙여 호출함
new User(); // function User { ... }
```

- 함수 본문에서 `new.target`을 사용하면 해당 함수가 `new`와 함께 호출되었는지("in constructor mode") 아닌지("in regular mode")를 확인할 수 있다.

```javascript
// 이를 활용해 일반적인 방법으로 함수를 호출해도 `new`를 붙여 호출한 것과 같이 동작하도록 하는 코드
function User(name) {
    if (!new.target) { // new 없이 호출해도
        return new User(name); // new를 붙여줍니다.
    }

    this.name = name;
}

let john = User("John"); // 'new User'를 쓴 것처럼 바꿔줍니다.
alert(john.name); // John
```

- 라이브러리를 분석하다 보면 위와 같은 방식으로 쓰인 걸 발견할 때가 있다.
  - 이런 방식을 사용하면 `new`를 붙여 함수를 호출하든 아니든 코드가 동일하게 동작하기 때문에 좀 더 유연하게 코드를 작성할 수 있다.
- 하지만 `new`를 생략하면 코드가 정확히 무슨 일을 하는지 알기 어렵다.
  - `new`가 붙어있으면 새로운 객체를 만든다는 걸 누구나 알 수 있는데...
  - 이 방법은 정말 필요한 경우에만 사용하고 남발하지 않는게 좋다.

## 생성자와 return문

- 생성자 함수엔 보통 `return`문이 없다.
  - 반환해야 할 것들은 모두 `this`에 저장되고, `this`는 자동으로 반환되기 때문에 반환문을 명시적으로 써 줄 필요가 없다.
- 그런데 만약 `return`문이 있다면?
  - 간단한 규치깅 적용된다.
    1. 객체를 `return`한다면, `this`대신 객체가 반환된다.
    2. 원시형을 `return`한다면, `return`문이 무시된다.
  - `return`뒤에 객체가 오면 생성자 함수는 해당 객체를 반환해주고, 이 외의 경우는 `this`가 반환된다.

```javascript
// 첫 번째 규칙이 적용돼, return은 this를 무시하고 객체를 반환한다.
function BigUser() {

    this.name = "John";

    return { name: "Godzilla" };  // <-- this가 아닌 새로운 객체를 반환함
}

alert( new BigUser().name );  // Godzilla
```

- 아무것도 `return`하지 않는 예시

```javascript
function SmallUser() {

    this.name = "John";

    return; // <-- this를 반환함
}

alert( new SmallUser().name );  // John
```

- `return`문이 있는 생성자 함수는 거의 없다.

---

- 괄호 생략하기
  - 인수가 없는 생성자 함수는 괄호를 생략해 호출할 수 있다.

```javascript
let user = new User; // <-- 괄호가 없음
// 아래 코드는 위 코드와 똑같이 동작
let user = new User();
```

---

## 생성자 내 메서드

- 생성자 함수를 사용하면 매개변수를 이용해 객체 내부를 자유롭게 구성할 수 있다.
  - 엄청난 유연성이 확보된다.
  - `this`에 프로퍼티 뿐만아니라 메서드를 더해주는 것도 가능하다.

```javascript
// new User(name)은 프로퍼티 name과 메서드 sayHi를 가진 객체를 만들어준다.
function User(name) {
    this.name = name;

    this.sayHi = function() {
        alert( "My name is: " + this.name );
    };
}

let john = new User("John");

john.sayHi(); // My name is: John

/*
john = {
   name: "John",
   sayHi: function() { ... }
}
*/
```

- class 문법을 사용하면 생성자 함수를 사용하는 것과 마찬가지로 복잡한 객체를 만들 수 있다.

# 옵셔널 체이닝 '?.'

- 옵셔널 체이닝(optional chaining) `?.`을 사용하면 프로퍼티가 없는 중첩 객체에도 에러 없이 안전하게 접근할 수 있다.

## 옵셔널 체이닝이 필요한 이유

- 사용자가 여러 명 있는데 그 중 몇 명은 주소 정보를 가지고 있지 않다고 가정하자.

```javascript
// user.address.street를 사용해 주소 정보에 접근하면 에러가 발생할 수 있다.
let user = {}; // 주소정보가 없는 사용자

alert(user.address.street); // TypeError: Cannot read property 'street' of undefined
```

- 또 다른 사례는 브라우저에서 동작하는 코드를 개발하는 도중에 발생할 수 있다.
  - 페이지에 특정 요소에 담긴 정보에 접근하려 하는데, 요소가 페이지에 없는 경우

```javascript
// querySelector(...) 호출 결과가 null인 경우
let html = document.querySelector('.my-element').innerHTML; //TypeError: Cannot read property 'innerHTML' of null
```

- 중첩 객체의 특정 프로퍼티에 접근하기 위해 거쳐야 할 구성요소들을 AND로 연결해 실제 해당 객체나 프로퍼티가 있는지 확인할 수 있었다.
  - 그런데 이렇게 AND를 연결해 사용하면 코드가 아주 길어진다는 문제가 생긴다.

## 옵셔널 체이닝의 등장

- `?.`은 `?.` '앞'의 평가 대상이 `undefined`나 `null`이면 평가를 멈추고 `undefined`를 반환한다.

```javascript
// 옵셔널 체이닝을 사용해 user.address.street에 안전하게 접근하는 예시
let user = {}; // 주소정보가 없는 사용자

alert( user?.address?.street ); // undefined, 에러가 발생하지 않는다.
```

- `user?.address`로 주소를 읽으면 아래처럼 `user` 객체가 존재하지 않더라도 에러가 발생하지 않는다.

```javascript
let user = null;

alert(user?.address); // undefined

alert(user?.address.street); // undefined
alert(user?.address.street.anything); // undefined
```

- `user?.` 평가가 끝나고 `user`에 값이 없다는 것이 발견되면 그 즉시 평가를 멈추기 때문에 마지막 두 줄에서 에러가 발생하지 않는다.
  - 평가가 끝나면 나머지 프로퍼티들엔 접근 자체를 하지 않기 때문
  - 다만 `user`가 존재하는 경우엔 `user.address` 같은 중간 프로퍼티들이 평가 대상이 되기 때문에 반드시 값이 있어야 에러가 발생하지 않는다.

---

- 옵셔널 체이닝을 남용하면 안된다.
  - `?.`는 존재하지 않아도 괜찮은 대상에만 사용해야 한다.
  - 사용자 주소 관련 위 예시에서 논리상 `user`는 반드시 있어야 하는데 `address`는 필수값이 아니다.  
    그러므로 `user.address?.street`를 사용하는 것이 바람직하다.
  - 실수로 인해 `user`에 값을 할당하지 않았다면 바로 알아낼 수 있도록 해야 한다.
    - 그렇지 않다면 에러를 조기에 발견하지 못하고 디버깅이 어려워진다.
- `?.`앞의 변수는 꼭 선언되어 있어야 한다.
  - 변수 `user`가 선언되어있지 않으면 `user?.anything` 평가시 에러가 발생한다.

```javascript
// ReferenceError: user is not defined
user?.address;
```

- 옵셔널 체이닝은 다른 언어 메커니즘엔 전혀 영향을 끼치지 않고 오직 `null/undefined`여부만 검사한다.

---

## 단락 평가

- `?.`는 왼쪽 평가대상에 값이 없으면 즉시 평가를 멈춘다(단락 평가, short-circuit).
  - 따라서 `?.` 오른쪽에 있는 함수 호출 등의 부가 동작들은 `?.`의 평가가 멈췄을 때 더는 일어나지 않는다.

```javascript
let user = null;
let x = 0;

user?.sayHi(x++); // 아무 일도 일어나지 않는다.

alert(x); // 0, x의 값은 증가하지 않는다.
```

## ?.()와 ?.[]

- `?.`은 연산자가 아니고 함수, 대괄호와 함께 동작하는 특별한 문법 구조체이다.
  - `?.()`는 존재 여부가 확실치 않은 함수를 호출할 때 쓸 수 있다.

```javascript
// 한 객체엔 메서드 admin이 있지만 다른 객체엔 없는 상황
let user1 = {
    admin() {
        alert("관리자 계정입니다.");
    }
}

let user2 = {};

user1.admin?.(); // 관리자 계정입니다.
user2.admin?.();
```

- `?.()`를 사용해 `admin`의 존재 여부를 확인한다.
  - `user1`엔 `admin`이 정의되어 있기 때문에 메서드가 제대로 호출되는 반면,  
    `user2`엔 `admin`이 정의되어 있지 않기 때문에 에러 없이 그냥 평가가 멈춘다.
- `.`대신 대괄호`[]`를 사용해 객체 프로퍼티에 접근하는 경우엔 `?.[]`를 사용할 수도 있다.
  - 마찬가지로 `?.[]`를 사용하면 프로퍼티 존재 여부가 확실치 않은 경우에도 안전하게 프로퍼티를 읽을 수 있다.

```javascript
let user1 = {
    firstName: "Violet",
};

let user2 = null; // user2는 권한이 없는 사용자라고 가정

let key = "firstName";

alert( user1?.[key] ); // Violet
alert( user2?.[key] ); // undefined

alert( user1?.[key]?.something?.not?.existing); // undefined
```

- `?.`은 `delete`와도 함께 사용할 수 있다.

```javascript
delete user?.name; // user가 존재하면 user.name을 삭제한다.
```

- `?.`은 읽거나 삭제하기에는 사용할 수 있지만 쓰기에는 사용할 수 없다.
  - `?.`은 할당 연산자 왼쪽에서 사용할 수 없다.

```javascript
// user가 존재할 경우 user.name에 값을 쓰려는 의도로 아래와 같이 코드를 작성

user?.name = "Violet"; // SyntaxError: Invalid left-hand side in assignment
// 에러가 발생하는 이유는 undefined = "Violet"이 되기 때문
```

# 심볼형

- 자바스크립트는 객체 프로퍼티 키로 오직 문자형과 심볼형만을 허용한다.
  - 숫자형, 불린형 모두 불가능하고 오직 문자형과 심볼형만 가능하다.

## 심볼

- 심볼(symbol)은 유일한 식별자(unique identifier)를 만들고 싶을 때 사용한다.

```javascript
// id는 새로운 심볼이 된다.
let id = Symbol();
```

- 심볼을 만들 때 심볼 이름이라 불리는 설명을 붙일 수도 있다.
  - 심볼 이름은 디버깅 시 아주 유용하다.

```javascript
// 심볼 id에는 "id"라는 설명이 붙습니다.
let id = Symbol("id");
```

- 심볼은 유일성이 보장되는 자료형이기 때문에 설명이 동일한 심볼을 여러 개 만들어도 각 심볼값은 다르다.
  - 심볼에 붙이는 설명은 어떤 것에도 영향을 주지 않는 이름표 역할만을 한다.

```javascript
let id1 = Symbol("id");
let id2 = Symbol("id");

alert(id1 == id2); // false
```

- 심볼은 문자형으로 자동 형 변환되지 않는다.
  - 자바스크립트에선 문자형으로의 암시적 형 변환이 비교적 자유롭게 일어나는 편이다.
  - `alert`함수가 거의 모든 값을 인자로 받을 수 있는 이유가 이 때문이다.
  - 그러나 심볼은 예외

```javascript
// 에러 예시
let id = Symbol("id");
alert(id); // TypeError: Cannot convert a Symbol value to a string
```

- 문자열과 심볼은 근본이 다르기 때문에 우연히라도 서로의 타입으로 변환돼선 안 된다.
  - 자바스크립트에선 '언어 차원의 보호장치(language guard)'를 마련해 심볼형이 다른 형으로 변환되지 않게 막아준다.
- 심볼을 반드시 출력해줘야 하는 상황이라면 `.toString()`메서드를 명시적으로 호출해주면 된다.

```javascript
let id = Symbol("id");
alert(id.toString()); // Symbol(id)가 얼럿 창에 출력됨
```

- `symbol.description` 프로퍼티를 이용하면 설명만 보여주는 것도 가능하다.

```javascript
let id = Symbol("id");
alert(id.description); // id
```

## '숨김' 프로퍼티

- 심볼을 이용하면 '숨김(hidden)' 프로퍼티를 만들 수 있다.
  - 숨김 프로퍼티는 외부 코드에서 접근이 불가능하고 값도 덮어쓸 수 없는 프로퍼티이다.
- 서드파티 코드에서 가지고 온 `user`라는 객체가 여러 개 있고, `user`를 이용해 어떤 작업을 해야 하는 상황이라고 가정하자.
  - `user`에 식별자를 붙이자.

```javascript
let user = { // 서드파티 코드에서 가져온 객체
    name: "John"
};

let id = Symbol("id");

user[id] = 1;

alert( user[id] ); // 심볼을 키로 사용해 데이터에 접근할 수 있습니다.
```

- 문자열 `id`를 키로 사용해도 되는데 `Symbol("id")`를 사용한 이유?
  - `user`는 서드파티 코드에서 가지고 온 객체이므로 함부로 새로운 프로퍼티를 추가할 수 없다.
  - 그런데 심볼은 서드파티 코드에서 접근할 수 없기 때문에, 심볼을 사용하면 코드가 모르게 `user`에 식별자를 부여할 수 있다.
- 제 3의 스크립트(자바스크립트 라이브러리)에서 `user`를 식별해야 하는 상황이 벌어졌다 해보자.
  - `user`의 원천인 서드파티 코드, 현재 작성 중인 스크립트, 제 3의 스크립트가 각자 서로의 코드도 모른 채 `user`를 식별해야 하는 상황
  - 제 3의 스크립트에선 아래처럼 `Symbol("id")`를 이용해 전용 식별자를 만들어 사용할 수 있다.

```javascript
// ...
let id = Symbol("id");

user[id] = "제3 스크립트 id 값";
```

- 심볼은 유일성이 보장되므로 우리가 만든 식별자와 제 3의 스크립트에서 만든 식별자는 이름이 같더라도 충돌하지 않는다.
  - 만약 심볼 대신 문자열 "id" 를 사용해 식별자를 만들었다면 충돌이 발생할 가능성이 있다.

```javascript
let user = {
    name: "John",
};

// 문자열 "id"를 사용해 식별자를 만든다.
user.id = "스크립트 id 값";

// 만약 제3의 스크립트가 우리 스크립트와 동일하게 문자열 "id"를 이용해 식별자를 만들었다면...?

user.id = "제3 스크립트 id 값"
// 의도치 않게 값이 덮어 쓰여서 우리가 만든 식별자는 무의미해진다.
```

### 객체 리터럴과 심볼

- 객체 리터럴`{...}`을 사용해 객체를 만든 경우, 대괄호를 사용해 심볼형 키를 만들어야 한다.

```javascript
let id = Symbol("id");

let user = {
    name: "John",
    [id]: 123 // "id: 123"은 안됨
};
// "id: 123"이라고 하면, 심볼 id가 아니라 문자열 "id"가 저장된다.
```

### 심볼은 for ... in에서 배제된다.

- 키가 심볼은 프로퍼티는 `for..in` 반복문에서 배제된다.

```javascript
let id = Symbol("id");
let user = {
    name: "John",
    age: 30,
    [id]: 123
};

for (let key in user) alert(key); // name과 age만 출력되고, 심볼은 출력되지 않는다.

// 심볼로 직접 접근하면 잘 작동한다.
alert( "직접 접근한 값: " + user[id] );
```

- `Object.keys(user)`에서도 키가 심볼은 프로퍼티는 배제된다.
  - 심볼형 프로퍼티 숨기기라 불리는 이런 원칙 덕분에 외부 스크립트나 라이브러리는 심볼형 키를 가진 프로퍼티에 접근하지 못한다.
- 그런데 Object.assign은 키가 심볼인 프로퍼티를 배제하지 않고 객체 내 모든 프로퍼티를 복사한다.

```javascript
let id = Symbol("id");
let user = {
    [id]: 123
};

let clone = Object.assign({}, user);

alert( clone[id] ); // 123
```

- 모순이 있는 것 같아 보이지만, 이는 의도적으로 설계된 것이다.
  - 객체를 복사하거나 병합할 때, 대개 `id` 같은 심볼을 포함한 프로퍼티 전부를 사용하고 싶어 할 것이라는 생각에서 이렇게 설계되었다.

## 전역 심볼

- 심볼은 이름이 같더라도 모두 별개로 취급된다.
  - 그런데 이름이 같은 심볼이 같은 개체를 가리키길 원하는 경우도 가끔 있다.
- 애플리케이션 곳곳에서 심볼 `"id"`를 이용해 특정 프로퍼티에 접근해야 한다고 가정해보자.
  - 전역 심볼 레지스트리는 이런 경우를 위해 만들어졌다.
  - 전역 심볼 레지스트리 안에 심볼을 만들고 해당 심볼에 접근하면, 이름이같은 경우 항상 동일한 심볼을 반환해준다.
- 레지스트리 안에 있는 심볼을 읽거나, 새로운 심볼을 생성하려면 `Symbol.for(key)`를 사용하면 된다.
  - 이 메서드를 호출하면 이름이 `key`인 심볼을 반환한다.
  - 조건에 맞는 심볼이 레지스트리 안에 없으면 새로운 심볼 `Symbol(key)`을 만들고 레지스트리 안에 저장한다.

```javascript
// 전역 레지스트리에서 심볼을 읽는다.
let id = Symbol.for("id"); // 심볼이 존재하지 않으면 새로운 심볼을 만든다.

// 동일한 이름을 이용해 심볼을 다시 읽는다(좀 더 멀리 떨어진 코드에서도 가능).
let idAgain = Symbol.for("id");

// 두 심볼은 같다.
alert( id === idAgain ); // true
```

- 전역 심볼 레지스트리 안에 있는 심볼은 전역 심볼이라고 불린다.
  - 애플리케이션에서 광범위하게 사용해야 하는 심볼이라면 전역 심볼을 사용하자.

### Symbol.keyFor

- 전역 심볼을 찾을 때 사용되는 `Symbol.for(key)`에 반대되는 메서드도 있다.
  - `Symbol.keyFor(sym)`를 사용하면 이름을 얻을 수 있다.

```javascript
// 이름을 이용해 심볼을 찾음
let sym = Symbol.for("name");
let sym2 = Symbol.for("id");

// 심볼을 이용해 이름을 얻음
alert( Symbol.keyFor(sym) ); // name
alert( Symbol.keyFor(sym2) ); // id
```

- `Symbol.keyFor`는 전역 심볼 레지스트리를 뒤져서 해당 심볼의 이름을 얻어낸다.
  - 검색 범위가 전역 심볼 레지스트리이기 때문에 전역 심볼이 아닌 심볼에는 사용할 수 없다.
  - 전역 심볼이 아닌 인자가 넘어오면 `Suybol.keyFor`는 `undefined`를 반환한다.
- 전역 심볼이 아닌 심볼을 포함한 심볼 모드에는 `description` 프로퍼티가 있다.
  - 일반 심볼에서 이름을 얻고싶으면 `description` 프로퍼티를 사용하면 된다.

```javascript
let globalSymbol = Symbol.for("name");
let localSymbol = Symbol("name");

alert( Symbol.keyFor(globalSymbol) ); // name, 전역 심볼
alert( Symbol.keyFor(localSymbol) ); // undefined, 전역 심볼이 아님

alert( localSymbol.description ); // name
```

## 시스템 심볼

- 시스템 심볼은 자바스크립트 내부에서 사용되는 심볼이다.
  - 시스템 심볼을 활용하면 객체를 미세 조정할 수 있다.
- 명세서 내의 표, 잘 알려진 심볼에서 어떤 시스템 심볼이 있을까
  - `Symbol.hasInstance`
  - `Symbol.isConcatSpreadable`
  - `Symbol.iterator`
  - `Symbol.toPrimitive`
  - 기타 등등

# 객체를 원시형으로 변환하기

- `obj1 + obj2`처럼 객체끼리 더하는 연산을 하거나, `obj1 - obj2`처럼 객체끼리 빼는 연산을 하면? alert(obj)로 객체를 출력할 때는?
  - 이 모든 경우 자동 형 변환이 일어난다.
  - 객체는 원시값으로 변환되고, 그 후 의도한 연산이 수행된다.

1. 객체는 논리 평가 시 단 하나의 예외도 없이 `true`를 반환한다.
   - 따라서 객체는 숫자형이나 문자형으로만 형변환이 일어난다.
2. 숫자형으로의 형 변환은 객체끼리 빼는 연산을 할 때나 수학 관련 함수를 적용할 때 일어난다.
   - 객체 `Date` 끼리 차감하면 (`date1 - date2`) 두 날짜의 시간 차이가 반환된다.
3. 문자형으로의 형 변환은 대개 `alert(obj)`같이 객체를 출력하려고 할 때 일어난다.

## ToPrimitive

- 특수 객체 메서드를 사용하면 숫자형이나 문자형으로의 형 변환을 원하는 대로 조절할 수 있다.
- 객체 형 변환은 세 종류로 구분된다.
  - 'hint'라 불리는 값이 구분 기준이 된다.
  - 'hint'는 '목표로 하는 자료형' 정도로 이해할 수 있다.

### "String"

- `alert` 함수같이 문자열을 기대하는 연산을 수행할 때는(객체-문자형 변환), hint가 `string`이 된다.

```javascript
// 객체를 출력하려고 한다.
alert(obj);

// 객체를 프로퍼티 키로 사용하고 있다.
anotherObj[obj] = 123;
```

### "number"

- 수학 연산을 적용하려 할 때(객체-숫자형 변환), hint는 `number`가 된다.

```javascript
// 명시적 형 변환
let num = Number(obj);

// 수학 연산(이항 덧셈 연산 제외)
let n = +obj; // 단항 덧셈 연산
let delta = date1 - date2;

// 크고 작음 비교하기
let greater = user1 > user2;
```

### "default"

- 연산자가 기대하는 자료형이 '확실치 않을 때'는 hint는 `default`가 된다.
  - 아주 드물게 발생
- 이항 덧셈 연산자 `+`는 피연산자의 자료형에 따라 문자열을 합치는 연산일 수도, 숫자를 더해주는 연산일 수도 있다.
  - 따라서 `+`의 인수가 객체일때 hint는 `default`가 된다.
- 동등 연산자`==`를 사용해 객체-문자형, 객체-숫자형, 객체-심볼형끼리 비교할 때도 객체를 어떤 자료형으로 바꿔야 할지 확신이 안 선다.
  - 그러므로 hint는 `default`가 된다.

```javascript
// 이항 덧셈 연산은 hint로 `default`를 사용한다.
let total = obj1 + obj2;

// obj == number 연산은 hint로 `default`를 사용한다.
```

- 크고 작음을 비교하는 연산자 `<, >` 역시 피연산자에 문자형과 숫자형 둘 다 허용한다.
  - 이 연산자들은 hint를 'number'로 고정한다. hint가 'default'가 되는 일은 없다.
  - 하위 호환성 때문에 정해진 규칙이다.
- 실제 일을 할 때 이런 사항을 모두 외울 필요는 없다.
  - `Date` 객체를 제외한 모든 내장 객체는 hint가 `"default"`인 경우와  `"number"`인 경우를 모두 동일하게 처리한다.
- `"boolean"` hint는 없다.
  - 모든 객체는 그냥 `true`로 평가된다.

<b>자바스크립트는 형 변환이 필요할 때, 아래와 같은 알고리즘에 따라 원하는 메서드를 찾고 호출한다.</b>

1. 객체에 obj[Symbol.toPrimitive]\(hint) 메서드가 있는지 찾고, 있다면 메서드를 호출한다.
   - 'Symbol.toPrimitive'는 시스템 심볼로, 심볼형 키로 사용된다.
2. 1에 해당하지 않고 hint가 `"String"`이라면
   - `obj.toString()`이나 `obj.valueOf()`를 호출한다(존재하는 메서드만 실행).
3. 1과 2에 해당하지 않고, hint가 `"number"`나 `"default"`라면
   - `obj.valueOf()`나 `obj.toString()`을 호출한다(존재하는 메서드만 실행).

## Symbol.toPrimitive

- 자바스크립트엔 `Symbol.toPrimitive`라는 내장 심볼이 존재한다.
  - 이 심볼은 목표로 하는 자료형(hint)을 명명하는 데 사용된다.

```javascript
obj[Symbol.toPrimitive] = function(hint) {
    // 반드시 원시값을 반환해야 한다.
    // hint는 "string", "number", "default" 중 하나가 될 수 있다.
};
```

- 실제 예시

```javascript
// user 객체에 객체-원시형 변환 메서드 구현
let user = {
    name: "John",
    money: 1000,
    
    [Symbol.toPrimitive](hint) {
        alert(`hint: ${hint}`);
        return hint == "string" ? `{name: "${this.name}"}` : this.money;
    }
};

alert(user); // hint: string -> {name: "John"}
alert(+user); // hint: number -> 1000
alert(user + 500); // hint: default -> 1500
```

- 이렇게 메서드를 구현해 놓으면 `user`는 hint에 따라(자기 자신을 설명해주는) 문자열로 변환되기도 하고  
  (가지고 있는 돈의 액수를 나타내는) 숫자로 변환되기도 한다.
  - `user[System.toPrimitive]`를 사용하면 메서드 하나로 모든 종류의 형 변환을 다룰 수 있다.

## toString과 valueOf

- `toString`과 `valueOf`는 심볼이 생기기 이전부터 존재해 왔던 '평범한' 메서드이다.
  - 이 메서드를 이용하면 구식이긴 하지만 형 변환을 직접 구현할 수 있다.
- 객체에 `Symbol.toPrimitive`가 없으면 자바스크립트는 규칙에 따라 `toString`이나 `valueOf`를 호출한다.
  - hint가 'string'인 경우 : `toString -> valueOf`순(`toString`이 있다면 `toString`을 호출, `toString`이 없다면 `valueOf`를 호출한다.)
  - 그 외 : `valueOf -> toString`순
- 이 메서드들은 반드시 원시값을 반환해야 한다.
  - 객체를 반환하면 그 결과는 무시된다(마치 메서드가 처음부터 없었던 것처럼).
- 일반 객체는 기본적으로 `toString`과 `valueOf`에 적용되는 규칙을 따른다.
  - `toString`은 문자열 `"[object Object]"`을 반환한다.
  - `valueOf`는 객체 자신을 반환한다.

```javascript
let user = {
    name: "John",
};

alert(user); // [object Object]
alert(user.valueOf() === user); // true
```

- `valueOf`는 객체 자신을 반환하기 때문에 그 결과를 무시된다.
  - 이 메서드가 존재하지 않는다고 생각하면 된다.
- 예시

```javascript
let user = {
    name: "John",
    money: 1000,
    
    // hint가 "string"인 경우
    toString() {
        return `{name: "${this.name}"}`;
    },
    
    // hint가 "number"나 "default"인 경우
    valueOf() {
        return this.money;
    }
}

alert(user); // toString -> {name: "John"}
alert(+user); // valueOf -> 1000
alert(user + 500); // valueOf -> 1500
```

- 간혹 모든 형 변환을 한 곳에서 처리해야 하는 경우도 생긴다.
  - 이럴 땐 `toString`만 구현해주면 된다.

```javascript
let user = {
    name: "John",
    
    toString() {
        return this.name;
    }
};

alert(user); // toString -> John
alert(user + 500); // toString -> John500
```

- 객체에 `Symbol.toPrimitive`와 `valueOf`가 없으면 `toString`이 모든 형 변환을 처리한다.

## 반환 타입

- 'hint'에 명시된 자료형으로의 형 변환을 보장해 주지 않는다.
  - `toString()`이 항상 문자열을 반환하리라는 보장이 없고,  
    `Symbole.toPrimitive`의 hint가 "number"일 때 항상 숫자형 자료가 반환되리라는 보장이 없다.
  - 확신할 수 있는 단 한 가지는 객체가 아닌 원시값을 반환해 준다는 것 뿐이다.

## 추가 형 변환

- 지금까지 살펴본 바와 같이 상당수의 연산자와 함수가 피연산자의 형을 변환시킨다.
  - 곱셈을 해주는 연산자 `*`는 피연산자를 숫자형으로 변환시킨다.
- 객체가 피연산자일 때는 아래와 같은 단계를 거쳐 형 변환이 일어난다.
  1. 객체는 원시형으로 변화된다.
  2. 변환 후 원시값이 원하는 형이 아닌 경우엔 또다시 형 변환이 일어난다.

```javascript
let obj = {
    // 다른 메서드가 없으면 toString에서 모든 형 변환을 처리
    toString() {
        return "2";
    }
};

alert(obj * 2); // 4, 객체가 문자열 "2"로 바뀌고, 곱셈 연산 과정에서 문자열 "2"는 숫자 2로 변경
```

- 이항 덧셈 연산은 위의 예시같은 상황에서는 문자열을 연결한다.

```javascript
let obj = {
    toString() {
        return "2";
    }
};

alert(obj + 2); // 22("2" + 2), 문자열이 반환되기 때문에 문자열끼리의 병합이 일어난다.
```

- `obj.toString()`만 사용해도 모든 변환을 다 다룰 수 있기 때문에, 실무에선 `obj.toString()`만 구현해도 충분한 경우가 많다.
  - 반환 값도 사람이 읽고 이해할 수 있는 형식이기 때문에 실용성 측면에서 다른 메서드에 뒤처지지 않는다.
  - `obj.toString()`은 로깅이나 디버깅 목적으로도 자주 사용된다.

