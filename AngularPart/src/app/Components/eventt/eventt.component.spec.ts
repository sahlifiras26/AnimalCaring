import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventtComponent } from './eventt.component';

describe('EventtComponent', () => {
  let component: EventtComponent;
  let fixture: ComponentFixture<EventtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
