![Java_8](https://img.shields.io/badge/java-v1.8-red?logo=java)

# LogAnalyzer

<br>

## Feature
* Java 8
* JUnit5
* Lombok

<br>

## 프로젝트 소개
입력받은 로그파일을 분석하여 <br>

1. 최다호출 APIKEY <br> 
2. (호출 횟수 기준) 상위 3개의 API Service ID와 각각의 요청 수 <br>
3. 웹브라우저별 사용비율 <br>

위의 3가지 분석데이터를 파일로 출력하는 프로그램 구현. <br>

<br>

## 프로그램 순서
1. 로그파일 파싱
2. 통계데이터 산출
3. 정해진 출력 폼 생성
4. 분석파일 출력

<br>

## 문제해결순서
1. 응답상태별로 List<V> 에 담은 후, Map<응답상태, 응답상태별 리스트> 처리
2. 파싱된 map데이터를 통계서비스에 전달
3. 최다호출apikey 산출 : 
    - Comparator 연산자 이용 최대값 계산
4. 상위 3개 service_id, 요청수 산출 :
    - Stream 이용 내림차순 정렬 후 상위3개 service_id, 요청수 산출
    - 요청수는 HashMap을 이용하여, 해당 service_id에 값을 더해주는 방식
5. 웹브라우저별 비율 산출
    - Stream 이용 내림차순 정렬
6. 산출된 데이터들을 FormMaker를 통해 문자열 처리
7. 분석파일 출력

<br>

## 클래스 설명
  - model
    - LogModel : 입력파일로부터 한 줄씩 LogModel 생성
    - UrlModel : 입력받은 URL을 대상으로 정상URL여부 판단(생성자+필터)
  - service
    - LogStatistic : 통계데이터 산출 서비스
  - utils
    - form
      - OutputFormMaker : 통계데이터들을 정해진 출력형식으로 변경
    - io
      - LogReader : 로그파일을 읽어들임
      - LogWriter : 주어진 포맷으로 분석파일을 생성
    - parse
      - LogParser : 입력받은 로그파일 데이터들을 Map형태로 변환
