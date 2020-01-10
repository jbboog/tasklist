import { TaskStatus } from './taskstatus';

export interface ITask {

  title : string;
  description : string;
  reporter : string;
  owner : string;
  status : TaskStatus;
  deadline : Date;
}

