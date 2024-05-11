# react-native-inapprating

In app review with in your app the latest arcticture 0.74 is supported

## Installation

```sh
npm install react-native-inapprating
```

## Usage

```js
import { ratingReview } from 'react-native-inapprating';

// ...

ratingReview().then((result)=>{
  if(result === 'true'){
    // put your flow here
  }. .catch((error) => {
    // we have some error could happen while lanuching InAppReview,
    console.log(error);
  });
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
