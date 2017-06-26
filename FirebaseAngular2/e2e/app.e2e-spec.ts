import { FirebasePollerPage } from './app.po';

describe('firebase-poller App', () => {
  let page: FirebasePollerPage;

  beforeEach(() => {
    page = new FirebasePollerPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
